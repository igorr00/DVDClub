package main.dto;

public class MarketplaceDTO {

	private String name;
	private String street;
	private String number;
	private String city;
	private String country;
	private String manager;
	
	public MarketplaceDTO() {
		super();
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getManager() {
		return manager;
	}

	public void setManagerId(String manager) {
		this.manager = manager;
	}
	
}
