package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Director {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "directorId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "directorName", nullable = false)
	private String name;

	@Column(name = "directorSurname", nullable = false)
	private String surname;
	
	@Column(name = "directorAge", nullable = false)
	private int age;
	
	@ManyToOne(targetEntity = Country.class, fetch = FetchType.EAGER)
    private Country country;

	public Director() {
		super();
	}

	public Director(Long id, String name, String surname, int age, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.country = country;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
