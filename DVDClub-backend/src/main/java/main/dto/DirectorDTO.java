package main.dto;

public class DirectorDTO {

	private String name;
	private String surname;
	private int age;
	private String country;
	
	public DirectorDTO() {
		super();
	}

	public DirectorDTO(String name, String surname, int age, String country) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
