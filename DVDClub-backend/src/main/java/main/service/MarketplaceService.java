package main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.MarketplaceDTO;
import main.model.Marketplace;
import main.model.SpecialOffer;
import main.model.User;
import main.model.City;
import main.model.Country;
import main.model.Dvd;
import main.repository.MarketplaceRepository;
import main.repository.UserRepository;
import main.repository.CountryRepository;
import main.repository.CityRepository;

@Service
public class MarketplaceService {

	@Autowired
	private MarketplaceRepository marketplaceRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Boolean add(MarketplaceDTO dto) {
		for(Marketplace m: marketplaceRepository.findAll()) {
			if(m.getStreet().equals(dto.getStreet()) && m.getNumber().equals(dto.getNumber()) && m.getCity().getName().equals(dto.getCity()) && m.getCity().getCountry().getName().equals(dto.getCountry())) {
				return false;
			}
		}
		
		Marketplace marketplace = new Marketplace();
		marketplace.setName(dto.getName());
		marketplace.setStreet(dto.getStreet());
		marketplace.setNumber(dto.getNumber());
		
		Country country = countryRepository.findByName(dto.getCountry());
		if(country != null) {
			for(City c: cityRepository.findAll()) {
				if(c.getCountry().equals(country) && c.getName().equals(dto.getCity())) {
					marketplace.setCity(c);
					marketplaceRepository.save(marketplace);
					return true;
				}
			}
		} else {
			country = new Country();
			country.setName(dto.getCountry());
			countryRepository.save(country);
		}
		
		City city = new City();
		city.setName(dto.getCity());
		city.setCountry(country);
		cityRepository.save(city);
		marketplace.setCity(city);
		marketplace.setManager(userRepository.findByEmail(dto.getManager()));
		marketplaceRepository.save(marketplace);
		return true;
	}
	
	public ArrayList<Marketplace> findAll(){
        ArrayList<Marketplace> marketplaces = new ArrayList<Marketplace>();
        for (Marketplace m: marketplaceRepository.findAll()) {
        	marketplaces.add(m);
        }
        return marketplaces;
    }
	
	public Boolean edit(Marketplace marketplace)
	{
		Optional<Marketplace> toEdit = marketplaceRepository.findById(marketplace.getId());
		if(!toEdit.isPresent())
		{
			return false;
		}

		marketplaceRepository.save(marketplace);
		return true;
	}
	
	public Marketplace findById(Long id) {
		return marketplaceRepository.findById(id).get();
	}
	
	public Boolean delete(Long id) {
		if(!marketplaceRepository.findById(id).get().getDvds().isEmpty() || !marketplaceRepository.findById(id).get().getSpecialOffers().isEmpty()) {
			return false;
		}
		
		marketplaceRepository.deleteById(id);
		return true;
	}
	
	public Marketplace findByManagerId(Long id){
        for (Marketplace m: marketplaceRepository.findAll()) {
        	if(m.getManager().getId().equals(id)) {
        		return m;
        	}
        }
        return null;
    }
	
	public List<Dvd> findAvailableDvds(Long id) {
		Marketplace marketplace = marketplaceRepository.findById(id).get();
		return marketplace.getAvailableDvds();
	}
	
	public List<SpecialOffer> findAvailableSpecialOffers(Long id) {
		Marketplace marketplace = marketplaceRepository.findById(id).get();
		return marketplace.getAvailableSpecialOffers();
	}
	
	public Boolean checkUser(Long marketplaceId, Long userId) {
		return marketplaceRepository.findById(marketplaceId).get().getUsers().contains(userRepository.findById(userId).get());
	}
	
	public Boolean membership(Long marketplaceId, Long userId) {
		if(checkUser(marketplaceId, userId)) {
			return false;
		}
		
		Marketplace marketplace = marketplaceRepository.findById(marketplaceId).orElseThrow(() -> new RuntimeException("Marketplace not found"));
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		marketplace.getUsers().add(user);
		marketplaceRepository.save(marketplace);
		
		return true;
	}
	public Boolean cancelMembership(Long marketplaceId, Long userId) {
		if(!checkUser(marketplaceId, userId)) {
			return false;
		}
		
		Marketplace marketplace = marketplaceRepository.findById(marketplaceId).orElseThrow(() -> new RuntimeException("Marketplace not found"));
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		marketplace.getUsers().remove(user);
		marketplaceRepository.save(marketplace);
		
		return true;
	}
}
