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
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ratingId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "ratingScore", nullable = false)
	private int score;
	
	@Column(name = "ratingComment", nullable = false)
	private String comment;
	
	@Column(name = "ratingDate", nullable = false)
	private LocalDate date;
	
	@Column(name = "ratingTime", nullable = false)
	private LocalTime time;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;
	
	@OneToOne(targetEntity = Film.class, fetch = FetchType.EAGER)
    private Film film;

	public Rating() {
		super();
	}

	public Rating(Long id, int score, String comment, LocalDate date, LocalTime time, User user, Film film) {
		super();
		this.id = id;
		this.score = score;
		this.comment = comment;
		this.date = date;
		this.time = time;
		this.user = user;
		this.film = film;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
}
