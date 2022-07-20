package com.hrodriguesdev.soauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrodriguesdev.soauth.entity.User;
import com.hrodriguesdev.soauth.feignclients.UserFeignClient;

@Service
public class UserService {
//	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeign;
	
	public User findByEmail(String email) {
		User user = userFeign.findByEmail(email).getBody();
		if(user == null) {
//			logger.error("Email not found " + email);
			throw new IllegalArgumentException("Email not found");
		}
//		logger.info("Email found " + email);
		return user;
	}
	
}
