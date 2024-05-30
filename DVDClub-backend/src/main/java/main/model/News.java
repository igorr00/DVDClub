package main.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "newsId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "newsDate", nullable = false)
	private LocalDate date;
	
	@Column(name = "newsTitle", nullable = false)
	private String title;
	
	@Column(name = "newsText", nullable = false)
	private String text;

	public News() {
		super();
	}

	public News(Long id, LocalDate date, String title, String text) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.text = text;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
