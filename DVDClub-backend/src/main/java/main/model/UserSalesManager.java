package main.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class UserSalesManager extends User {

	@OneToOne(targetEntity = Marketplace.class, fetch = FetchType.EAGER)
    private Marketplace marketplace;

	public UserSalesManager() {
		super();
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}
	
}
