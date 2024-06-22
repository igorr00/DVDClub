package main.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.dto.RatingDTO;
import main.model.Rating;
import main.service.RatingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/add")
	public ResponseEntity<Rating> add(@RequestBody RatingDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(ratingService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<Rating> getAll(){
		return ratingService.findAll();
	}
	
	@PostMapping("/edit")
    public @ResponseBody Boolean edit(@RequestBody Rating rating){
		return ratingService.edit(rating);	
	}
	
	@GetMapping("/getById")
    public @ResponseBody Rating getById(@Param("id") Long id){
		return ratingService.findById(id);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody void delete(@Param("id") Long id){
		ratingService.delete(id);
	}
	
	@GetMapping("/getByUserId")
    public @ResponseBody ArrayList<Rating> getByUserId(@Param("id") Long id){
		return ratingService.findByUserId(id);
	}
	
	@GetMapping("/getByFilmId")
    public @ResponseBody ArrayList<Rating> getByFilmId(@Param("id") Long id){
		return ratingService.findByFilmId(id);
	}
}
