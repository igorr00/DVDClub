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
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User manager;
	
	@ManyToOne(targetEntity = City.class, fetch = FetchType.EAGER)
    private City city;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "marketplace_dvd",
            joinColumns = @JoinColumn(name = "marketplace_id"),
            inverseJoinColumns = @JoinColumn(name = "dvd_id"))
    private List<Dvd> dvds;
	
	/*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "marketplace_user",
            joinColumns = @JoinColumn(name = "marketplace_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserCustomer> users;*/

	public Marketplace() {
		super();
	}

	public Marketplace(Long id, String name, String street, String number, User manager, City city, List<Dvd> dvds) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.number = number;
		this.manager = manager;
		this.city = city;
		this.dvds = dvds;
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

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
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
}