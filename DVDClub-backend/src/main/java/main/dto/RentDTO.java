package main.dto;

public class RentDTO {
	
	private Long userId;
	private Long dvdId;
	
	public RentDTO() {
		super();
	}

	public RentDTO(Long userId, Long dvdId) {
		super();
		this.userId = userId;
		this.dvdId = dvdId;
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
}
