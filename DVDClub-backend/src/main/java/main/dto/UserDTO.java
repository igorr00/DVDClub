package main.dto;

import main.model.Gender;
import main.model.UserType;

public class UserDTO {
	
	private String name;
	private String surname;
	private String email;
	private String password;
	private String jmbg;
	private String phone;
	private Gender gender;
	private UserType type;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String name, String surname, String email, String password, String jmbg, String phone, Gender gender,
			UserType type) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.jmbg = jmbg;
		this.phone = phone;
		this.gender = gender;
		this.type = type;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
}
