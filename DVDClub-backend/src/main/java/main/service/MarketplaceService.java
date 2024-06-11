package main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.MarketplaceDTO;
import main.model.Marketplace;
import main.model.City;
import main.model.Country;
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
}
