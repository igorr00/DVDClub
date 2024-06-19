package main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ArrayUtils;

import main.dto.SpecialOfferDTO;
import main.model.SpecialOffer;
import main.model.Dvd;
import main.model.Film;
import main.model.Marketplace;
import main.repository.DvdRepository;
import main.repository.FilmRepository;
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
		specialOffer.setPrice(dto.getPrice());
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
}
