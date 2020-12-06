package com.example.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.login.domain.model.User;
import com.example.login.domain.repository.UserDao;

@Transactional
@Service
public class RestServiceJdbcImpl implements RestService {

	@Autowired
	@Qualifier("UserDaoJdbcImpl")
	UserDao dao;
	
	@Override
	public boolean insert(User user) {
		
		int result = dao.insertOne(user);
		
		if (result == 0) {
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public List<User> selectMany() {
		return dao.selectMany();
	}

}
