package main.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.RatingDTO;
import main.model.Rating;
import main.repository.FilmRepository;
import main.repository.RatingRepository;
import main.repository.UserRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	public Boolean add(RatingDTO dto) {
		for(Rating r: ratingRepository.findAll()) {
			if(r.getUser().getId().equals(dto.getUserId()) && r.getFilm().getId().equals(dto.getFilmId())) {
				return false;
			}
		}
		
		Rating rating = new Rating();
		rating.setScore(dto.getScore());
		rating.setComment(dto.getComment());
		rating.setDate(LocalDate.now());
		rating.setTime(LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute()));
		rating.setUser(userRepository.findById(dto.getUserId()).get());
		rating.setFilm(filmRepository.findById(dto.getFilmId()).get());
		
		ratingRepository.save(rating);
		return true;
	}
	
	public ArrayList<Rating> findAll(){
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        for (Rating r: ratingRepository.findAll()) {
        	ratings.add(r);
        }
        return ratings;
    }
	
	public Boolean edit(Rating rating)
	{
		Optional<Rating> toEdit = ratingRepository.findById(rating.getId());
		if(!toEdit.isPresent())
		{
			return false;
		}

		ratingRepository.save(rating);
		return true;
	}
	
	public Rating findById(Long id) {
		return ratingRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		ratingRepository.deleteById(id);
	}
	
	public ArrayList<Rating> findByUserId(Long id){
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        for (Rating r: ratingRepository.findAll()) {
        	if(r.getUser().getId().equals(id)) {
        		ratings.add(r);
        	}
        }
        return ratings;
    }
	
	public ArrayList<Rating> findByFilmId(Long id){
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        for (Rating r: ratingRepository.findAll()) {
        	if(r.getFilm().getId().equals(id)) {
        		ratings.add(r);
        	}
        }
        return ratings;
    }
	
}
