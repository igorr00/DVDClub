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

import main.dto.FilmDTO;
import main.model.Film;
import main.service.FilmService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "film")
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	@PostMapping("/add")
	public ResponseEntity<Film> add(@RequestBody FilmDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(filmService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<Film> getAll(){
		return filmService.findAll();
	}
	
	@PostMapping("/edit")
    public @ResponseBody Boolean edit(@RequestBody Film film){
		return filmService.edit(film);	
	}
	
	@GetMapping("/getById")
    public @ResponseBody Film getById(@Param("id") Long id){
		return filmService.findById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@Param("id") Long id){
		if(filmService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
