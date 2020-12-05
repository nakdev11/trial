package com.example.login.domain.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.login.domain.model.User;

@Repository
public class UserDaoJdbcImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbc;
	
	public int count() throws DataAccessException {

		int count = jdbc.queryForObject("select count(*) from m_user", Integer.class);
		
		return count;
	}

	public int insertOne(User user) throws DataAccessException {
		int rowNumber = jdbc.update("insert into m_user(user_id,"
				+ " password, user_name, birthday, age, role)" 
				+ " values(?, ?, ?, ?, ?, ?)"
				, user.getUserId()
				, user.getPassword()
				, user.getUserName()
				, user.getBirthday()
				, user.getAge()
				, user.getRole());
	
		return rowNumber;
	}

	public User selectOne(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> selectMany() throws DataAccessException {
		List<Map<String, Object>> getList = jdbc.queryForList("select * from m_user");
		
		List<User> userList = new ArrayList<>();
		
		for (Map<String, Object> map : getList) {
			
			User user = new User();
			
			user.setUserId((String)map.get("user_id"));
			user.setPassword((String)map.get("password"));
			user.setUserName((String)map.get("user_name"));
			user.setBirthday((Date)map.get("birthday"));
			user.setAge((Integer)map.get("age"));
			user.setRole((String)map.get("role"));
			
			userList.add(user);
		}
		
		return userList;
	
	}

	public int updateOne(User user) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteOne(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void userCsvOut() throws DataAccessException {
		// TODO Auto-generated method stub

	}

}
