package com.hrodriguesdev.soauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrodriguesdev.soauth.entity.User;
import com.hrodriguesdev.soauth.services.UserService;

@Controller
@RequestMapping(value = "/oauth")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		try {
			User user = service.findByEmail(email);
			return ResponseEntity.ok().body(user);
			
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
			
	}
	
}
