package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.login.domain.model.SignupForm;
import com.example.login.domain.model.User;
import com.example.login.domain.service.UserService;

@Controller
public class SignupController {
	
	@Autowired
	UserService userService;

	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm signupForm, Model model) {
		return "login/signup";
	}
	
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm signupForm,
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			return getSignUp(signupForm, model);
		}
		
		System.out.println(signupForm);
		
		User user = new User();
		
		user.setUserId(signupForm.getUserId());
		user.setPassword(signupForm.getPassword());
		user.setUserName(signupForm.getUserName());
		user.setBirthday(signupForm.getBirthday());
		user.setAge(signupForm.getAge());
		user.setRole("ROLE_GENERAL");
		
		boolean result = userService.insert(user);
		
		if (result) {
			System.out.println("insert成功");
		} else {
			System.out.println("insert失敗");
		}
		
		return "redirect:login";
	}
	
	
}
