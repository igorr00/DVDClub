package main.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.DvdDTO;
import main.model.Dvd;
import main.model.Film;
import main.model.Marketplace;
import main.repository.DvdRepository;
import main.repository.FilmRepository;
import main.repository.MarketplaceRepository;

@Service
public class DvdService {

	@Autowired
	private DvdRepository dvdRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private MarketplaceRepository marketplaceRepository;
	
	public Boolean add(DvdDTO dto) {
		Dvd dvd = new Dvd();
		dvd.setFormat(dto.getFormat());
		dvd.setPriceBuy(dto.getPriceBuy());
		dvd.setPriceRent(dto.getPriceRent());
		Optional<Film> film = filmRepository.findById(dto.getFilmId());
		if(film.isEmpty()) {
			return false;
		}
		dvd.setFilm(film.get());
		dvd.setAvailable(true);
		dvdRepository.save(dvd);
		
		Marketplace marketplace = marketplaceRepository.findById(dto.getMarketplaceId()).orElseThrow(() -> new RuntimeException("Marketplace not found"));
		marketplace.getDvds().add(dvd);
		
		marketplaceRepository.save(marketplace);
		return true;
	}
	
	public ArrayList<Dvd> findAll(){
        ArrayList<Dvd> dvds = new ArrayList<Dvd>();
        for (Dvd d: dvdRepository.findAll()) {
        	if(d.isAvailable()) {
        		dvds.add(d);
        	}
        }
        return dvds;
    }
	
	public Boolean edit(Dvd dvd)
	{
		Optional<Dvd> toEdit = dvdRepository.findById(dvd.getId());
		if(!toEdit.isPresent())
		{
			return false;
		}

		dvdRepository.save(dvd);
		return true;
	}
	
	public Dvd findById(Long id) {
		return dvdRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		for(Marketplace m: marketplaceRepository.findAll()) {
			if(m.getAvailableDvds().contains(dvdRepository.findById(id).get())) {
				m.getDvds().remove(dvdRepository.findById(id).get());
				marketplaceRepository.save(m);
			}
		}
		
		dvdRepository.deleteById(id);
	}
}
