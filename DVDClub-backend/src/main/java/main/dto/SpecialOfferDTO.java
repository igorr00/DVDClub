package main.dto;

import java.time.LocalDate;

public class SpecialOfferDTO {

	private String name;
	private int price;
	private LocalDate startDate;
	private LocalDate endDate;
	private Long[] dvdIds;
	private Long marketplaceId;
	
	public SpecialOfferDTO() {
		super();
	}

	public SpecialOfferDTO(String name, int price, LocalDate startDate, LocalDate endDate, Long[] dvdIds, Long marketplaceId) {
		super();
		this.name = name;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dvdIds = dvdIds;
		this.marketplaceId = marketplaceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Long[] getDvdIds() {
		return dvdIds;
	}

	public void setDvdIds(Long[] dvdIds) {
		this.dvdIds = dvdIds;
	}

	public Long getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(Long marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
}
