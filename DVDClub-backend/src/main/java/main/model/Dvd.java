package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dvd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dvdId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "dvdFormat", nullable = false)
	private String format;
	
	@Column(name = "dvdPriceBuy", nullable = false)
	private int priceBuy;
	
	@Column(name = "dvdPriceRent", nullable = false)
	private int priceRent;
	
	@ManyToOne(targetEntity = Film.class, fetch = FetchType.EAGER)
    private Film film;
	
	private boolean available;

	public Dvd() {
		super();
	}

	public Dvd(Long id, String format, int priceBuy, int priceRent, Film film, boolean available) {
		super();
		this.id = id;
		this.format = format;
		this.priceBuy = priceBuy;
		this.priceRent = priceRent;
		this.film = film;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getPriceBuy() {
		return priceBuy;
	}

	public void setPriceBuy(int priceBuy) {
		this.priceBuy = priceBuy;
	}

	public int getPriceRent() {
		return priceRent;
	}

	public void setPriceRent(int priceRent) {
		this.priceRent = priceRent;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
