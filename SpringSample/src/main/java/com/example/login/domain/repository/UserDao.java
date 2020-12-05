package com.example.login.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.login.domain.model.User;

public interface UserDao {

	public int count() throws DataAccessException;
	
	public int insertOne(User user) throws DataAccessException;
	
	public User selectOne(String userId) throws DataAccessException;
	
	public List<User> selectMany() throws DataAccessException;
	
	public int updateOne(User user) throws DataAccessException;
	
	public int deleteOne(String userId) throws DataAccessException;
	
	public void userCsvOut() throws DataAccessException;
	
}
