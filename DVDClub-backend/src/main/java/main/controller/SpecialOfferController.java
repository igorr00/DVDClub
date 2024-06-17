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

import main.dto.SpecialOfferDTO;
import main.model.SpecialOffer;
import main.service.SpecialOfferService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "specialOffer")
public class SpecialOfferController {

	@Autowired
	private SpecialOfferService specialOfferService;
	
	@PostMapping("/add")
	public ResponseEntity<SpecialOffer> add(@RequestBody SpecialOfferDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(specialOfferService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<SpecialOffer> getAll(){
		return specialOfferService.findAll();
	}
	
	@PostMapping("/edit")
    public @ResponseBody Boolean edit(@RequestBody SpecialOffer specialOffer){
		return specialOfferService.edit(specialOffer);	
	}
	
	@GetMapping("/getById")
    public @ResponseBody SpecialOffer getById(@Param("id") Long id){
		return specialOfferService.findById(id);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody void delete(@Param("id") Long id){
		specialOfferService.delete(id);
	}
}
