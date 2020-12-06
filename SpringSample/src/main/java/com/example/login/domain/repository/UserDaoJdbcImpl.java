package com.example.login.domain.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.login.domain.model.User;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public int count() throws DataAccessException {

		int count = jdbc.queryForObject("select count(*) from m_user", Integer.class);
		
		return count;
	}

	public int insertOne(User user) throws DataAccessException {
		
		String password = passwordEncoder.encode(user.getPassword());
		
		int rowNumber = jdbc.update("insert into m_user(user_id,"
				+ " password, user_name, birthday, age, role)" 
				+ " values(?, ?, ?, ?, ?, ?)"
				, user.getUserId()
				, password
				, user.getUserName()
				, user.getBirthday()
				, user.getAge()
				, user.getRole());
	
		return rowNumber;
	}

	@Override
	public User selectOne(String userId) throws DataAccessException {
		
		Map<String, Object> map = jdbc.queryForMap("select * from m_user where user_id = ?", userId);
	
		User user = new User();
		
		user.setUserId((String)map.get("user_id"));
		user.setPassword((String)map.get("password"));
		user.setUserName((String)map.get("user_name"));
		user.setBirthday((Date)map.get("birthday"));
		user.setAge((Integer)map.get("age"));
		user.setRole((String)map.get("role"));

		return user;
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

	@Override
	public int updateOne(User user) throws DataAccessException {

		String password = passwordEncoder.encode(user.getPassword());
		
		int rowNumber = jdbc.update("update m_user set password = ?, user_name = ?, birthday = ?, age = ? where user_id = ?"
				, password
				, user.getUserName()
				, user.getBirthday()
				, user.getAge()
				, user.getUserId());
	
//		// トランザクション確認
//		if (rowNumber > 0) {
//			throw new DataAccessException("トランザクションテスト") {};
//		}
		
		return rowNumber;
		
	}

	public int deleteOne(String userId) throws DataAccessException {

		int rowNumber = jdbc.update("delete from m_user where user_id = ?", userId);
		
		return rowNumber;
	
	}

	public void userCsvOut() throws DataAccessException {
		// TODO Auto-generated method stub

	}

}
