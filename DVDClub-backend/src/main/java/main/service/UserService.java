package main.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.User;
import main.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Boolean register(User user) throws MessagingException, UnsupportedEncodingException {
		User userTemp = userRepository.findByEmail(user.getEmail());
		if(userTemp != null) {
			return false;
		}
		//String randomCode = RandomString.make(64);
	    //user.setVerificationCode(randomCode);
	    //user.setEnabled(false);
		userRepository.save(user);
		//sendVerificationEmail(user);
		
		return true;
	}
}
