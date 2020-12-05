package com.example.login.domain.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class SignupForm {

	@NotBlank
	@Email
	private String userId;

	@NotBlank
	@Length(min=4, max=100)
	private String password;
	
	@NotBlank
	private String userName;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date birthday;

	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		
		return "userId: " + this.userId + " password: " + this.password + " userName: "
		+ this.userName + " birthday: " + this.birthday + " age: " + this.age;
	}
	
	
}
