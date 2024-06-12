package main.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.ActorDTO;
import main.model.Actor;
import main.model.Country;
import main.repository.ActorRepository;
import main.repository.CountryRepository;

@Service
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	public Boolean add(ActorDTO dto) {
		Actor actor = new Actor();
		actor.setName(dto.getName());
		actor.setSurname(dto.getSurname());
		actor.setAge(dto.getAge());
		Country country = countryRepository.findByName(dto.getCountry());
		if(country != null) {
			actor.setCountry(country);
		} else {
			country = new Country();
			country.setName(dto.getCountry());
			countryRepository.save(country);
			actor.setCountry(country);
		}
		actorRepository.save(actor);
		return true;
	}
	
	public ArrayList<Actor> findAll(){
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (Actor a: actorRepository.findAll()) {
        	actors.add(a);
        }
        return actors;
    }
	
	public Boolean edit(Actor actor)
	{
		Optional<Actor> toEdit = actorRepository.findById(actor.getId());
		if(!toEdit.isPresent())
		{
			return false;
		}

		actorRepository.save(actor);
		return true;
	}
	
	public Actor findById(Long id) {
		return actorRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		actorRepository.deleteById(id);
	}
}
