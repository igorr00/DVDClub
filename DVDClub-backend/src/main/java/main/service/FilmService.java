package main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.FilmDTO;
import main.model.Film;
import main.model.Genre;
import main.model.Actor;
import main.model.Country;
import main.repository.FilmRepository;
import main.repository.GenreRepository;
import main.repository.ActorRepository;
import main.repository.CountryRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	public Boolean add(FilmDTO dto) {
		Film film = new Film();
		film.setName(dto.getName());
		film.setYear(dto.getYear());
		Country country = countryRepository.findByName(dto.getCountry());
		if(country != null) {
			film.setCountry(country);
		} else {
			country = new Country();
			country.setName(dto.getCountry());
			countryRepository.save(country);
			film.setCountry(country);
		}
		film.setFilmStudio(dto.getFilmStudio());
		List<Genre> genres = new ArrayList<Genre>();
		for(Genre g: dto.getGenres()) {
			Optional<Genre> genre = genreRepository.findById(g.getId());
			genres.add(genre.get());
		}
		film.setGenres(genres);;
		film.setDirector(dto.getDirector());
		List<Actor> actors = new ArrayList<Actor>();
		for(Actor a: dto.getActors()) {
			Optional<Actor> actor = actorRepository.findById(a.getId());
			actors.add(actor.get());
		}
		film.setActors(actors);
		film.setImage(dto.getImage());
		
		filmRepository.save(film);
		return true;
	}
	
	public ArrayList<Film> findAll(){
        ArrayList<Film> films = new ArrayList<Film>();
        for (Film f: filmRepository.findAll()) {
        	films.add(f);
        }
        return films;
    }
}
