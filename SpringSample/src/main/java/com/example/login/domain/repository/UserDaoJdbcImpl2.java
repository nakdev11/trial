package com.example.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.login.domain.model.User;

@Repository("UserDaoJdbcImpl2")
public class UserDaoJdbcImpl2 extends UserDaoJdbcImpl {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public User selectOne(String userId) {
		
		String sql = "select * from m_user where user_id = ?";
		
		UserRowMapper rowMapper = new UserRowMapper();
		
		return jdbc.queryForObject(sql, rowMapper, userId);
	}

	@Override
	public List<User> selectMany() {
		
		String sql = "select * from m_user";
		
		RowMapper<User> rowMapper = new UserRowMapper();
		
		return jdbc.query(sql, rowMapper);
		
	}
	
}
