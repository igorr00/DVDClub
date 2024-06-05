package main.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Marketplace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marketplaceId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "marketplaceName", nullable = false)
	private String name;
	
	@Column(name = "marketplaceStreet", nullable = false)
	private String street;
	
	@Column(name = "marketplaceNumber", nullable = false)
	private String number;
	
	@ManyToOne(targetEntity = City.class, fetch = FetchType.EAGER)
    private City city;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "marketplace_dvd",
            joinColumns = @JoinColumn(name = "marketplace_id"),
            inverseJoinColumns = @JoinColumn(name = "dvd_id"))
    private List<Dvd> dvds;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "marketplace_special_offer",
            joinColumns = @JoinColumn(name = "marketplace_id"),
            inverseJoinColumns = @JoinColumn(name = "special_offer_id"))
    private List<SpecialOffer> specialOffers;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "marketplace_user",
            joinColumns = @JoinColumn(name = "marketplace_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserCustomer> users;

	public Marketplace() {
		super();
	}

	public Marketplace(Long id, String name, String street, String number, City city, List<Dvd> dvds,
			List<SpecialOffer> specialOffers, List<UserCustomer> users) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.number = number;
		this.city = city;
		this.dvds = dvds;
		this.specialOffers = specialOffers;
		this.users = users;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Dvd> getDvds() {
		return dvds;
	}

	public void setDvds(List<Dvd> dvds) {
		this.dvds = dvds;
	}

	public List<SpecialOffer> getSpecialOffers() {
		return specialOffers;
	}

	public void setSpecialOffers(List<SpecialOffer> specialOffers) {
		this.specialOffers = specialOffers;
	}

	public List<UserCustomer> getUsers() {
		return users;
	}

	public void setUsers(List<UserCustomer> users) {
		this.users = users;
	}
}
