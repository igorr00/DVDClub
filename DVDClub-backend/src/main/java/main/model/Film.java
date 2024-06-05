package main.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "filmId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "filmName", nullable = false)
	private String name;
	
	@Column(name = "filmYear", nullable = false)
	private int year;
	
	@ManyToOne(targetEntity = Country.class, fetch = FetchType.EAGER)
    private Country country;
	
	@ManyToOne(targetEntity = FilmStudio.class, fetch = FetchType.EAGER)
    private FilmStudio filmStudio;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "film_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;
	
	@ManyToOne(targetEntity = Director.class, fetch = FetchType.EAGER)
    private Director director;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;
	
	@Column(name = "filmImage", nullable = false)
	private String image;

	public Film() {
		super();
	}

	public Film(Long id, String name, int year, Country country, FilmStudio filmStudio,
			List<Genre> genres, Director director, List<Actor> actors, String image) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.country = country;
		this.filmStudio = filmStudio;
		this.genres = genres;
		this.director = director;
		this.actors = actors;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
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
