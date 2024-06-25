package main.dto;

public class PurchaseDTO {

	private Long userId;
	private Long dvdId;
	private Long specialOfferId;
	
	public PurchaseDTO() {
		super();
	}

	public PurchaseDTO(Long userId, Long dvdId, Long specialOfferId) {
		super();
		this.userId = userId;
		this.dvdId = dvdId;
		this.specialOfferId = specialOfferId;
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

	public Long getSpecialOfferId() {
		return specialOfferId;
	}

	public void setSpecialOfferId(Long specialOfferId) {
		this.specialOfferId = specialOfferId;
	}
	
}
