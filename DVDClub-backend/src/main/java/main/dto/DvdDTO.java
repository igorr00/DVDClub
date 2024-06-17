package main.dto;

public class DvdDTO {

	private String format;
	private int priceBuy;
	private int priceRent;
	private Long filmId;
	private Long marketplaceId;
	
	public DvdDTO() {
		super();
	}

	public DvdDTO(String format, int priceBuy, int priceRent, Long filmId, Long marketplaceId) {
		super();
		this.format = format;
		this.priceBuy = priceBuy;
		this.priceRent = priceRent;
		this.filmId = filmId;
		this.marketplaceId = marketplaceId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getPriceBuy() {
		return priceBuy;
	}

	public void setPriceBuy(int priceBuy) {
		this.priceBuy = priceBuy;
	}

	public int getPriceRent() {
		return priceRent;
	}

	public void setPriceRent(int priceRent) {
		this.priceRent = priceRent;
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public Long getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(Long marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
	
}
