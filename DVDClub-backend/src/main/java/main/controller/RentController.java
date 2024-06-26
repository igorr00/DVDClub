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

import main.dto.RentDTO;
import main.model.Rent;
import main.model.RentStatus;
import main.service.RentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "rent")
public class RentController {

	@Autowired
	private RentService rentService;
	
	@PostMapping("/add")
	public ResponseEntity<Rent> add(@RequestBody RentDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(rentService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<Rent> getAll(){
		return rentService.findAll();
	}
	
	@GetMapping("/getByUserId")
    public @ResponseBody ArrayList<Rent> getByUserId(@Param("id") Long id){
		return rentService.findByUserId(id);
	}
	
	@GetMapping("/getByMarketplaceId")
    public @ResponseBody ArrayList<Rent> getByMarketplaceId(@Param("id") Long id){
		return rentService.findByMarketplaceId(id);
	}
	
	@PostMapping("/changeStatus")
    public @ResponseBody Boolean getByMarketplaceId(@Param("id") Long id, @Param("status") RentStatus status){
		return rentService.changeStatus(id, status);
	}
}
