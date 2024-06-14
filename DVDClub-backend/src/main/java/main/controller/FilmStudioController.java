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

import main.dto.FilmStudioDTO;
import main.model.FilmStudio;
import main.model.User;
import main.service.FilmStudioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "filmStudio")
public class FilmStudioController {
	
	@Autowired
	private FilmStudioService filmStudioService;
	
	@PostMapping("/add")
	public ResponseEntity<FilmStudio> add(@RequestBody FilmStudioDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(filmStudioService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<FilmStudio> getAll(){
		return filmStudioService.findAll();
	}
	
	@PostMapping("/edit")
    public @ResponseBody Boolean edit(@RequestBody FilmStudio filmStudio){
		return filmStudioService.edit(filmStudio);	
	}
	
	@GetMapping("/getById")
    public @ResponseBody FilmStudio getById(@Param("id") Long id){
		return filmStudioService.findById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@Param("id") Long id){
		if(filmStudioService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
