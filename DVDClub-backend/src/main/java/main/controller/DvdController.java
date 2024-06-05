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

import main.dto.DvdDTO;
import main.model.Dvd;
import main.service.DvdService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "dvd")
public class DvdController {

	@Autowired
	private DvdService dvdService;
	
	@PostMapping("/add")
	public ResponseEntity<Dvd> addDvd(@RequestBody DvdDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(dvdService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<Dvd> getAll(){
		return dvdService.findAll();
	}
}
