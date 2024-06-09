package main.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import main.model.Genre;
import main.repository.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	public ArrayList<Genre> findAll(){
        ArrayList<Genre> genres = new ArrayList<Genre>();
        for (Genre g: genreRepository.findAll()) {
        	genres.add(g);
        }
        return genres;
    }
}
