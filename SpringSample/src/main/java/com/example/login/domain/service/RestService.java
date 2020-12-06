package com.example.login.domain.service;

import java.util.List;

import com.example.login.domain.model.User;

public interface RestService {

	public boolean insert(User user);
	
	public List<User> selectMany();
	
}
