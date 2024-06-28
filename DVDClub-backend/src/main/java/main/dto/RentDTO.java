package main.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class RentDTO {
	
	private Long userId;
	private Long dvdId;
	private LocalDate date;
	
	public RentDTO() {
		super();
	}

	public RentDTO(Long userId, Long dvdId, LocalDate date) {
		super();
		this.userId = userId;
		this.dvdId = dvdId;
		this.date = date;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDvdId() {
		return dvdId;
	}

	public void setDvdId(Long dvdId) {
		this.dvdId = dvdId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
