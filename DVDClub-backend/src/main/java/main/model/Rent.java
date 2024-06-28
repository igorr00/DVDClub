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
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rentId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "rentDate", nullable = false)
	private LocalDate date;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;
	
	@OneToOne(targetEntity = Dvd.class, fetch = FetchType.EAGER)
    private Dvd dvd;
	
	@Column(name = "rentDue", nullable = false)
	private LocalDate due;
	
	@Column(name = "rentDateReturned")
	private LocalDate dateReturned;
	
	@Column(name = "rentStatus", nullable = false)
	private RentStatus status;

	public Rent() {
		super();
	}

	public Rent(Long id, LocalDate date, User user, Dvd dvd, LocalDate due, LocalDate dateReturned, RentStatus status) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.dvd = dvd;
		this.due = due;
		this.dateReturned = dateReturned;
		this.status = status;
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

	public LocalDate getDue() {
		return due;
	}

	public void setDue(LocalDate due) {
		this.due = due;
	}

	public LocalDate getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(LocalDate dateReturned) {
		this.dateReturned = dateReturned;
	}

	public RentStatus getStatus() {
		return status;
	}

	public void setStatus(RentStatus status) {
		this.status = status;
	}
}
