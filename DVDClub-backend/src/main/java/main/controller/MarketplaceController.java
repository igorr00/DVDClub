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

import main.dto.MarketplaceDTO;
import main.model.Marketplace;
import main.service.MarketplaceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "marketplace")
public class MarketplaceController {

	@Autowired
	private MarketplaceService marketplaceService;
	
	@PostMapping("/add")
	public ResponseEntity<Marketplace> add(@RequestBody MarketplaceDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(marketplaceService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<Marketplace> getAll(){
		return marketplaceService.findAll();
	}
	
	@PostMapping("/edit")
    public @ResponseBody Boolean edit(@RequestBody Marketplace marketplace){
		return marketplaceService.edit(marketplace);	
	}
	
	@GetMapping("/getById")
    public @ResponseBody Marketplace getById(@Param("id") Long id){
		return marketplaceService.findById(id);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody void delete(@Param("id") Long id){
		marketplaceService.delete(id);
	}
}
