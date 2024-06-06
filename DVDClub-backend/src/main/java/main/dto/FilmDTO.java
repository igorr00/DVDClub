package main.dto;

import java.util.List;

import main.model.Actor;
import main.model.Director;
import main.model.FilmStudio;
import main.model.Genre;

public class FilmDTO {
	
	private String name;
	private int year;
	private String country;
	private FilmStudio filmStudio;
	private List<Genre> genres;
	private Director director;
	private List<Actor> actors;
	private String image;
	
	public FilmDTO() {
		super();
	}

	public FilmDTO(String name, int year, String country, FilmStudio filmStudio, List<Genre> genres, Director director,
			List<Actor> actors, String image) {
		super();
		this.name = name;
		this.year = year;
		this.country = country;
		this.filmStudio = filmStudio;
		this.genres = genres;
		this.director = director;
		this.actors = actors;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public FilmStudio getFilmStudio() {
		return filmStudio;
	}

	public void setFilmStudio(FilmStudio filmStudio) {
		this.filmStudio = filmStudio;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
