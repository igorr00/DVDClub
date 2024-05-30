package main.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchaseId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "purchaseDate", nullable = false)
	private LocalDate date;
	
	@Column(name = "purchaseTime", nullable = false)
	private LocalTime time;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;
	
	@OneToOne(targetEntity = Dvd.class, fetch = FetchType.EAGER)
    private Dvd dvd;
	
	@OneToOne(targetEntity = SpecialOffer.class, fetch = FetchType.EAGER)
    private SpecialOffer specialOffer;

	public Purchase() {
		super();
	}

	public Purchase(Long id, LocalDate date, LocalTime time, User user, Dvd dvd, SpecialOffer specialOffer) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.user = user;
		this.dvd = dvd;
		this.specialOffer = specialOffer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dvd getDvd() {
		return dvd;
	}

	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
	}

	public SpecialOffer getSpecialOffer() {
		return specialOffer;
	}

	public void setSpecialOffer(SpecialOffer specialOffer) {
		this.specialOffer = specialOffer;
	}
}
