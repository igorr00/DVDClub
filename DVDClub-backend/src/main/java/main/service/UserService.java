package main.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import main.dto.UserDTO;
import main.model.User;
import main.model.UserCustomer;
import main.repository.UserRepository;
import net.bytebuddy.utility.RandomString;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private JavaMailSender mailSender;
	
	public User login(UserDTO user) {
		UserCustomer temp = (UserCustomer) userRepository.findByEmail(user.getEmail());
		if(temp != null) {
			if(temp.getPassword().equals(user.getPassword())){
				if(temp.isEnabled()) {
					return temp;
				}
			}
		}
		return null;
	}
	
	public Boolean register(UserCustomer user) throws MessagingException, UnsupportedEncodingException {
		User userTemp = userRepository.findByEmail(user.getEmail());
		if(userTemp != null) {
			return false;
		}
		String randomCode = RandomString.make(64);
	    user.setVerificationCode(randomCode);
	    user.setEnabled(false);
		userRepository.save(user);
		sendVerificationEmail(user);
		
		return true;
	}
	
	public void sendVerificationEmail(UserCustomer user) throws MessagingException, UnsupportedEncodingException {
	    String toAddress = user.getEmail();
	    String fromAddress = "ISA-Email";
	    String senderName = "FTN";
	    String subject = "Please verify your registration";
	    String content = "Dear [[name]],<br>"
	            + "Please click the link below to verify your registration:<br>"
	            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
	            + "Thank you,<br>"
	            + "FTN.";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", user.getName() + " " + user.getSurname());
	    String verifyURL = "http://localhost:8091/user/verify?code=" + user.getVerificationCode();
	     
	    content = content.replace("[[URL]]", verifyURL);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	}
	
	public boolean verify(String verificationCode) {
	    UserCustomer user = (UserCustomer) userRepository.findByVerificationCode(verificationCode);
	     
	    if (user == null || user.isEnabled()) {
	        return false;
	    } else {
	        user.setVerificationCode(null);
	        user.setEnabled(true);
	        userRepository.save(user);
	         
	        return true;
	    }
	     
	}
}
