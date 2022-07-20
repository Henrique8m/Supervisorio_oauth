package com.hrodriguesdev.soauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrodriguesdev.soauth.entity.User;

@Component
// Consumidor da requisição
@FeignClient(name = "s-user", path = "/users")
public interface UserFeignClient {
	
	
	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);

}
