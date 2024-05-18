package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "userName", nullable = false)
	private String name;
	
	@Column(name = "userSurname", nullable = false)
	private String surname;
	
	@Column(name = "userEmail", unique = true, nullable = false)
	private String email;
	
	@Column(name = "userPassword", nullable = false)
	private String password;
	
	@Column(name = "userJmbg", unique = true, nullable = false)
	private String jmbg;
	
	@Column(name = "userPhone", nullable = false)
	private String phone;
	
	@Column(name = "userGender", nullable = false)
	private Gender gender;
	
	@Column(name = "userType", nullable = false)
	private UserType type;


	public User(Long id, String name, String surname, String email, String password, String jmbg, String phone,
			Gender gender, UserType type) {
		super();
		this.id = id;
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