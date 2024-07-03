package main.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import main.dto.SpecialOfferDTO;
import main.model.SpecialOffer;
import main.model.Dvd;
import main.model.Marketplace;
import main.repository.DvdRepository;
import main.repository.MarketplaceRepository;
import main.repository.SpecialOfferRepository;

@Service
public class SpecialOfferService {
	
	@Autowired
	private SpecialOfferRepository specialOfferRepository;

	@Autowired
	private DvdRepository dvdRepository;
	
	@Autowired
	private MarketplaceRepository marketplaceRepository;
	
	public Boolean add(SpecialOfferDTO dto) {
		SpecialOffer specialOffer = new SpecialOffer();
		specialOffer.setName(dto.getName());
		specialOffer.setDiscount(dto.getDiscount());
		specialOffer.setStartDate(dto.getStartDate());
		specialOffer.setEndDate(dto.getEndDate());
		specialOffer.setAvailable(true);
		
		ArrayList<Dvd> dvds = new ArrayList<Dvd>();
		
		for(Dvd d: dvdRepository.findAll()) {
			if(Arrays.stream(dto.getDvdIds()).anyMatch(i -> i == d.getId())){
				d.setAvailable(false);
				dvdRepository.save(d);
				dvds.add(d);
			}
		}
		specialOffer.setDvds(dvds);
		double priceTemp = 0.0;
		for(Dvd d: dvds) {
			priceTemp += d.getPriceBuy();
		}
		priceTemp = (priceTemp * (1 - dto.getDiscount()/100.0));
		specialOffer.setPrice(priceTemp);
		specialOfferRepository.save(specialOffer);
		
		Marketplace marketplace = marketplaceRepository.findById(dto.getMarketplaceId()).orElseThrow(() -> new RuntimeException("Marketplace not found"));
		marketplace.getSpecialOffers().add(specialOffer);

	    marketplaceRepository.save(marketplace);

	    return true;
	}
	
	public ArrayList<SpecialOffer> findAll(){
        ArrayList<SpecialOffer> specialOffers = new ArrayList<SpecialOffer>();
        for (SpecialOffer so: specialOfferRepository.findAll()) {
        	if(so.isAvailable()) {
        		specialOffers.add(so);
        	}
        }
        return specialOffers;
    }
	
	public Boolean edit(SpecialOffer specialOffer)
	{
		Optional<SpecialOffer> toEdit = specialOfferRepository.findById(specialOffer.getId());
		if(!toEdit.isPresent())
		{
			return false;
		}
		
		double priceTemp = 0.0;
		for(Dvd d: specialOffer.getDvds()) {
			priceTemp += d.getPriceBuy();
		}
		priceTemp = (priceTemp * (1 - specialOffer.getDiscount()/100.0));
		specialOffer.setPrice(priceTemp);

		specialOfferRepository.save(specialOffer);
		return true;
	}
	
	public SpecialOffer findById(Long id) {
		return specialOfferRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		for (Dvd d : specialOfferRepository.findById(id).get().getDvds()) {
		    dvdRepository.findById(d.getId()).get().setAvailable(true);
		    dvdRepository.save(dvdRepository.findById(d.getId()).get());
		}
		
		for(Marketplace m: marketplaceRepository.findAll()) {
			if(m.getAvailableSpecialOffers().contains(specialOfferRepository.findById(id).get())) {
				m.getSpecialOffers().remove(specialOfferRepository.findById(id).get());
				marketplaceRepository.save(m);
			}
		}
		
		specialOfferRepository.deleteById(id);
	}
	
	@Scheduled(cron = "0 0 0 * * *")
    public void checkAvailability() {
		System.out.println("checkAvailability fired");
        LocalDate currentDate = LocalDate.now();
        List<SpecialOffer> specialOffers = specialOfferRepository.findAll();

        for (SpecialOffer so : specialOffers) {
            if (currentDate.isAfter(so.getEndDate())) {
                so.setAvailable(false);
                specialOfferRepository.save(so);
            }
        }
    }
}
