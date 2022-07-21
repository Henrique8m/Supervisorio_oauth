package com.hrodriguesdev.soauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrodriguesdev.soauth.entity.User;
import com.hrodriguesdev.soauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeign.findByEmail(username).getBody();
		if(user == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return user;
	}
	
}
