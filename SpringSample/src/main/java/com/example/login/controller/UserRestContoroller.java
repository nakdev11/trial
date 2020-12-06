package com.example.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.domain.model.User;
import com.example.login.domain.service.RestService;

@RestController
public class UserRestContoroller {
	
	@Autowired
	RestService service;
	
	@GetMapping("/rest/get")
	public List<User> getUserMany() {
		
		return service.selectMany();
	}
	
	@PostMapping("/rest/insert")
	public String postUserOne(@RequestBody User user) {
		
		boolean result = service.insert(user);
		
		String str = "";
		
		if (result) {
			str = "(\"result\":\"ok\"}";
		} else {
			str = "(\"result\":\"error\"}";
		}
		
		return str;
	}
	
}
