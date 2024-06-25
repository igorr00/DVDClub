package main.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.dto.PurchaseDTO;
import main.model.Purchase;
import main.service.PurchaseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	
	@PostMapping("/add")
	public ResponseEntity<Purchase> add(@RequestBody PurchaseDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(purchaseService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<Purchase> getAll(){
		return purchaseService.findAll();
	}
	
	@GetMapping("/getByUserId")
    public @ResponseBody ArrayList<Purchase> getByUserId(@Param("id") Long id){
		return purchaseService.findByUserId(id);
	}
}
