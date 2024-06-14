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

import main.dto.UserDTO;
import main.model.User;
import main.model.UserType;
import main.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<User> logIn(@RequestBody UserDTO userDTO){
		User loggedInUser = userService.login(userDTO);
		if(loggedInUser != null) {
			return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/registration")
	public ResponseEntity<User> register(@RequestBody UserDTO userDTO) throws MessagingException, UnsupportedEncodingException {

		User user = new User();
		
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setJmbg(userDTO.getJmbg());
		user.setPhone(userDTO.getPhone());
		user.setGender(userDTO.getGender());
		user.setType(userDTO.getType());		
		if(userService.register(user)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
	    if (userService.verify(code)) {
	        return "verify_success";
	    } else {
	        return "verify_fail";
	    }
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> add(@RequestBody UserDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(userService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAllManagers")
    public @ResponseBody ArrayList<User> getAllManagers(){
		return userService.findAllManagers();
	}
	
	@GetMapping("/getAllFreeManagers")
    public @ResponseBody ArrayList<User> getAllFreeManagers(){
		return userService.findAllFreeManagers();
	}
	
	@PostMapping("/edit")
    public @ResponseBody Boolean edit(@RequestBody User user){
		return userService.edit(user);	
	}
	
	@GetMapping("/getById")
    public @ResponseBody User getById(@Param("id") Long id){
		return userService.findById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@Param("id") Long id){
		if(userService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
