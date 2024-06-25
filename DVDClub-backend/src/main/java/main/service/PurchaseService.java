package main.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.PurchaseDTO;
import main.model.Purchase;
import main.model.Dvd;
import main.model.SpecialOffer;
import main.model.User;
import main.repository.DvdRepository;
import main.repository.PurchaseRepository;
import main.repository.SpecialOfferRepository;
import main.repository.UserRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private DvdRepository dvdRepository;
	
	@Autowired
	private SpecialOfferRepository specialOfferRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Boolean add(PurchaseDTO dto) {
		Purchase purchase = new Purchase();
		purchase.setDate(LocalDate.now());
		purchase.setTime(LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute()));
		
		Optional<User> user = userRepository.findById(dto.getUserId());
		if(user.isEmpty()) {
			return false;
		}
		purchase.setUser(user.get());
		
		if(dto.getDvdId() != 0) {
			Optional<Dvd> dvd = dvdRepository.findById(dto.getDvdId());
			if(dvd.isEmpty()) {
				return false;
			}
			purchase.setDvd(dvd.get());
			Dvd dvd2 = dvdRepository.findById(dto.getDvdId()).orElseThrow(() -> new RuntimeException("Dvd not found"));
			dvd2.setAvailable(false);
			dvdRepository.save(dvd2);
		} else {
			Optional<SpecialOffer> specialOffer = specialOfferRepository.findById(dto.getSpecialOfferId());
			if(specialOffer.isEmpty()) {
				return false;
			}
			purchase.setSpecialOffer(specialOffer.get());
			SpecialOffer specialOffer2 = specialOfferRepository.findById(dto.getSpecialOfferId()).orElseThrow(() -> new RuntimeException("SpecialOffer not found"));
			specialOffer2.setAvailable(false);
			specialOfferRepository.save(specialOffer2);
		}
		
		purchaseRepository.save(purchase);
		
		return true;
	}
	
	public ArrayList<Purchase> findAll(){
        ArrayList<Purchase> purchases = new ArrayList<Purchase>();
        for (Purchase p: purchaseRepository.findAll()) {
        	purchases.add(p);
        }
        return purchases;
    }
	
	public ArrayList<Purchase> findByUserId(Long id){
        ArrayList<Purchase> purchases = new ArrayList<Purchase>();
        for (Purchase p: purchaseRepository.findAll()) {
        	if(p.getUser().equals(userRepository.findById(id).get())) {
        		purchases.add(p);
        	}
        }
        return purchases;
    }
}
