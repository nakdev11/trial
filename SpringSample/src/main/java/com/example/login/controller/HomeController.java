package com.example.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.login.domain.model.SignupForm;
import com.example.login.domain.model.User;
import com.example.login.domain.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("contents", "login/home :: home_contents");
		return "login/homeLayout";
	}
	
	@PostMapping("/logout")
	public String postLogout() {
		return "redirect:/login";
	}
	
	@GetMapping("/userList")
	public String getUserList(Model model) {
		
		model.addAttribute("contents", "login/userList :: userList_contents");
		
		List<User> userList = userService.selectMany();
		
		model.addAttribute("userList", userList);
		
		int count = userService.count();
		
		model.addAttribute("userListCount", count);
		
		return "login/homeLayout";
	}
	
	@GetMapping("/logout")
	public String getLogout() {
		return "redirect:/login";
	}
	
	@GetMapping("/userList/csv")
	public String getUserListCsv(Model model) {
		return getUserList(model);
	}
	
	@GetMapping("/userDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute SignupForm form,
			Model model,
			@PathVariable("id") String userId) {
		
		System.out.println("userId = " + userId);
		
		model.addAttribute("contents", "login/userDetail :: userDetail_contents");
		
		if (userId != null && userId.length() > 0) {
			
			User user = userService.selectOne(userId);
			
			form.setUserId(user.getUserId());
			form.setPassword(user.getPassword());
			form.setUserName(user.getUserName());
			form.setBirthday(user.getBirthday());
			form.setAge(user.getAge());
			
			model.addAttribute("signupForm", form);
		}
		
		return "login/homeLayout";
	}
	
	@PostMapping(value = "/userDetail", params = "update")
	public String postUserDetailUpdate(@ModelAttribute SignupForm form, Model model) {
		
		System.out.println("更新ボタンの処理");
		
		User user = new User();
		
		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setBirthday(form.getBirthday());
		user.setAge(form.getAge());
		
		boolean result = userService.update(user);
		
		if (result) {
			model.addAttribute("result", "更新成功");
		} else {
			model.addAttribute("result", "更新失敗");			
		}
		
		return getUserList(model);
	}
	
	@PostMapping(value = "/userDetail", params = "delete")
	public String postUserDetailDelete(@ModelAttribute SignupForm form, Model model) {
		
		System.out.println("削除ボタンの処理");
		
		boolean result = userService.delete(form.getUserId());
		
		if (result) {
			model.addAttribute("result", "削除成功");
		} else {
			model.addAttribute("result", "削除失敗");			
		}
		
		return getUserList(model);
	}
	
	// アドミン権限専用画面
	@GetMapping("/admin")
	public String getAdmin(Model model) {
		
		model.addAttribute("contents", "login/admin :: admin_contents");
		
		return "login/homeLayout";
	}
	
}
