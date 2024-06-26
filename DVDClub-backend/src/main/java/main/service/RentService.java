package main.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Boolean add(RentDTO dto) {
		Rent rent = new Rent();
		rent.setDate(LocalDate.now());
		rent.setTime(LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute()));
		
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
		rentRepository.save(rent);
		return true;
	}
}
