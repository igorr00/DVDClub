package main.model;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class UserCustomer extends User {

	@Column(name = "verificationCode", length = 64)
    private String verificationCode;
	
	private boolean enabled;

	public UserCustomer() {
		super();
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
