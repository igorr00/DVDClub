package main.dto;

public class RatingDTO {
	
	private int score;
	private String comment;
	private Long userId;
	private Long filmId;
	
	public RatingDTO() {
		super();
	}

	public RatingDTO(int score, String comment, Long userId, Long filmId) {
		super();
		this.score = score;
		this.comment = comment;
		this.userId = userId;
		this.filmId = filmId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	
}
