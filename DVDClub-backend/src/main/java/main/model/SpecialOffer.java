package main.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class SpecialOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "specialOfferId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "specialOfferName", nullable = false)
	private String name;
	
	@Column(name = "specialOfferDiscount", nullable = false)
	private double discount;
	
	@Column(name = "specialOfferPrice", nullable = false)
	private double price;
	
	@Column(name = "specialOfferStartDate", nullable = false)
	private LocalDate startDate;
	
	@Column(name = "specialOfferEndDate", nullable = false)
	private LocalDate endDate;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "special_offer_dvd",
            joinColumns = @JoinColumn(name = "special_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "dvd_id"))
    private List<Dvd> dvds;
	
	private boolean available;

	public SpecialOffer() {
		super();
	}

	public SpecialOffer(Long id, String name, int discount, double price, LocalDate startDate, LocalDate endDate, List<Dvd> dvds, boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dvds = dvds;
		this.available = available;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<Dvd> getDvds() {
		return dvds;
	}

	public void setDvds(List<Dvd> dvds) {
		this.dvds = dvds;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
