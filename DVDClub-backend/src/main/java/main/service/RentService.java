package main.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import main.dto.RentDTO;
import main.model.Dvd;
import main.model.Marketplace;
import main.model.Rent;
import main.model.RentStatus;
import main.model.User;
import main.repository.DvdRepository;
import main.repository.MarketplaceRepository;
import main.repository.RentRepository;
import main.repository.UserRepository;

@Service
public class RentService {

	@Autowired
	private RentRepository rentRepository;
	
	@Autowired
	private DvdRepository dvdRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MarketplaceRepository marketplaceRepository;
	
	@Autowired
    private JavaMailSender mailSender;
	
	public Boolean add(RentDTO dto) {
		Rent rent = new Rent();
		rent.setDate(dto.getDate());
		
		Optional<User> user = userRepository.findById(dto.getUserId());
		if(user.isEmpty()) {
			return false;
		}
		rent.setUser(user.get());
		
		Optional<Dvd> dvd = dvdRepository.findById(dto.getDvdId());
		if(dvd.isEmpty()) {
			return false;
		}
		rent.setDvd(dvd.get());
		Dvd dvd2 = dvdRepository.findById(dto.getDvdId()).orElseThrow(() -> new RuntimeException("Dvd not found"));
		dvd2.setAvailable(false);
		dvdRepository.save(dvd2);
		
		rent.setDue(LocalDate.now().plusDays(7));
		rent.setStatus(RentStatus.Pending);
		
		rentRepository.save(rent);
		
		return true;
	}
	
	public ArrayList<Rent> findAll(){
        ArrayList<Rent> rents = new ArrayList<Rent>();
        for(Rent r: rentRepository.findAll()) {
        	rents.add(r);
        }
        return rents;
    }
	
	public ArrayList<Rent> findByUserId(Long id){
        ArrayList<Rent> rents = new ArrayList<Rent>();
        for(Rent r: rentRepository.findAll()) {
        	if(r.getUser().equals(userRepository.findById(id).get())) {
        		rents.add(r);
        	}
        }
        return rents;
    }
	
	public ArrayList<Rent> findByMarketplaceId(Long id){
        ArrayList<Rent> rents = new ArrayList<Rent>();
        Marketplace marketplace = marketplaceRepository.findById(id).get();
        for (Dvd d: marketplace.getDvds()) {
        	for(Rent r: rentRepository.findAll()) {
        		if(d.getId().equals(r.getDvd().getId())) {
        			rents.add(r);
        		}
        	}
        }
        return rents;
    }
	
	public Boolean changeStatus(Long id, RentStatus status) {
		Rent rent = rentRepository.findById(id).get();
		rent.setStatus(status);
		if(status.equals(RentStatus.Returned)) {
			rent.setDateReturned(LocalDate.now());
		}
		if(status.equals(RentStatus.Returned) || status.equals(RentStatus.Rejected)) {
			Dvd dvd = dvdRepository.findById(rent.getDvd().getId()).orElseThrow(() -> new RuntimeException("Dvd not found"));
			dvd.setAvailable(true);
			dvdRepository.save(dvd);
		}
		rentRepository.save(rent);
		return true;
	}
	
	public void sendWarningEmail(Rent rent) throws MessagingException, UnsupportedEncodingException {
	    String toAddress = rent.getUser().getEmail();
	    String fromAddress = "Dvd-Email";
	    String senderName = "DVDCLUB";
	    String subject = "Your rent has not been returned";
	    String content = "Dear [[name]],<br>"
	            + "Your rent for [[film]] ([[year]]) [[format]] has not been returned!<br>"
	            + "Please return it in a span of 3 days or we will be prompted to deactivate your account.<br>"
	            + "Thank you,<br>"
	            + "DVDCLUB.";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", rent.getUser().getName() + " " + rent.getUser().getSurname());
	    content = content.replace("[[film]]", rent.getDvd().getFilm().getName());
	    content = content.replace("[[year]]", String.valueOf(rent.getDvd().getFilm().getYear()));
	    content = content.replace("[[format]]", rent.getDvd().getFormat());
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	}
	
	@Scheduled(cron = "0 0 0 * * *")
    public void checkRentsDue() throws UnsupportedEncodingException, MessagingException {
		System.out.println("checkRentsDue fired");
        LocalDate currentDate = LocalDate.now();
        List<Rent> rents = rentRepository.findAll();

        for (Rent r : rents) {
            if (currentDate.equals(r.getDue().plusDays(1)) && r.getStatus().equals(RentStatus.Taken)) {
                sendWarningEmail(r);
            } else if (currentDate.equals(r.getDue().plusDays(3)) && r.getStatus().equals(RentStatus.Taken)) {
            	r.getUser().setEnabled(false);
            	userRepository.save(r.getUser());
            }
        }
    }
}
