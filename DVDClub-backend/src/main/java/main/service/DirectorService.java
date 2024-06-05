package main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.DirectorDTO;
import main.model.Country;
import main.model.Director;
import main.repository.CountryRepository;
import main.repository.DirectorRepository;

@Service
public class DirectorService {

	@Autowired
	private DirectorRepository directorRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	public Boolean add(DirectorDTO dto) {
		Director director = new Director();
		director.setName(dto.getName());
		director.setSurname(dto.getSurname());
		director.setAge(dto.getAge());
		Country country = countryRepository.findByName(dto.getCountry());
		if(country != null) {
			director.setCountry(country);
		} else {
			country = new Country();
			country.setName(dto.getCountry());
			countryRepository.save(country);
			director.setCountry(country);
		}
		directorRepository.save(director);
		return true;
	}
	
	public ArrayList<Director> findAll(){
        ArrayList<Director> directors = new ArrayList<Director>();
        for (Director a: directorRepository.findAll()) {
        	directors.add(a);
        }
        return directors;
    }
}
