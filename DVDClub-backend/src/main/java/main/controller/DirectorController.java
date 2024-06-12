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

import main.dto.DirectorDTO;
import main.model.Director;
import main.service.DirectorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "director")
public class DirectorController {

	@Autowired
	private DirectorService directorService;
	
	@PostMapping("/add")
	public ResponseEntity<Director> add(@RequestBody DirectorDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(directorService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<Director> getAll(){
		return directorService.findAll();
	}
	
	@PostMapping("/edit")
    public @ResponseBody Boolean edit(@RequestBody Director director){
		return directorService.edit(director);	
	}
	
	@GetMapping("/getById")
    public @ResponseBody Director getById(@Param("id") Long id){
		return directorService.findById(id);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody void delete(@Param("id") Long id){
		directorService.delete(id);
	}
}
