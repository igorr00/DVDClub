package main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.FilmStudioDTO;
import main.model.FilmStudio;
import main.model.Country;
import main.repository.FilmStudioRepository;
import main.repository.CountryRepository;

@Service
public class FilmStudioService {

	@Autowired
	private FilmStudioRepository filmStudioRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	public Boolean add(FilmStudioDTO dto) {
		FilmStudio filmStudio = new FilmStudio();
		filmStudio.setName(dto.getName());
		Country country = countryRepository.findByName(dto.getCountry());
		if(country != null) {
			filmStudio.setCountry(country);
		} else {
			country = new Country();
			country.setName(dto.getCountry());
			countryRepository.save(country);
			filmStudio.setCountry(country);
		}
		filmStudioRepository.save(filmStudio);
		return true;
	}
	
	public ArrayList<FilmStudio> findAll(){
        ArrayList<FilmStudio> filmStudios = new ArrayList<FilmStudio>();
        for (FilmStudio fs: filmStudioRepository.findAll()) {
        	filmStudios.add(fs);
        }
        return filmStudios;
    }
}
