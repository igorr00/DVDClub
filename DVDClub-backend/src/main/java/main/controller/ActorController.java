package main.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.dto.ActorDTO;
import main.model.Actor;
import main.service.ActorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "actor")
public class ActorController {

	@Autowired
	private ActorService actorService;
	
	@PostMapping("/add")
	public ResponseEntity<Actor> addActor(@RequestBody ActorDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(actorService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<Actor> getAll(){
		return actorService.findAll();
	}
}
