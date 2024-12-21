package com.microsoft.fusion.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.microsoft.fusion.dao.UserDao;
import com.microsoft.fusion.entity.User;
import com.microsoft.fusion.responsestructure.ResponseStructure;
import com.microsoft.fusion.service.UserService;

import jakarta.mail.internet.MimeMessage;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user=userDao.saveUser(user);
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.addTo(user.getEmail());
			mimeMessageHelper.setSubject("Account created");
			mimeMessageHelper.setText("<html><body style='color:red;background:blue; '><h1>Hello "+user.getName()+" Your Account has been Created Successfully</h1></body></html>",true);
			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Saved Ssuccessfully").body(user).build());
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> users=userDao.findAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Saved Ssuccessfully").body(users).build());

	}
	
}
