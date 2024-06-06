package main.model;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class UserCustomer extends User {

	@Column(name = "verificationCode", length = 64)
    private String verificationCode;

	public UserCustomer() {
		super();
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
}
