package main.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/registration")
	public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO) throws MessagingException, UnsupportedEncodingException {

		User user = new User();
		
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setJmbg(userDTO.getJmbg());
		user.setPhone(userDTO.getPhone());
		user.setGender(userDTO.getGender());
		user.setType(UserType.Registered);
		
		if(userService.register(user)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
