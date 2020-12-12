package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@Autowired
	PersonRepository repository;
	
	@GetMapping("/")
	public String index(SearchForm searchForm, Model model) {
		List<Person> list = repository.findAll();
		model.addAttribute("persons", list);
		return "index";
	}
	
	// ボタンを揃える
	@PostMapping(value="/", params="search")
	public String search(
			@Validated SearchForm searchForm,
			BindingResult result,
			Model model) {
		
		if (result.hasErrors()) {
			return "index";
		} 

//		if (searchForm.getId() == null || searchForm.getId().isEmpty()  ) { 
//		if (searchForm.getId().isBlank()) {
		if (searchForm.getId().isEmpty()) {
			List<Person> list = repository.findAll();
			model.addAttribute("persons", list);
			return "index";			
		} else {
			List<Person> list = repository.findById(Integer.parseInt(searchForm.getId()));
			model.addAttribute("persons", list);
			return "index";
		}
	}
	
	// ボタンを揃える
//	@GetMapping(value="/", params="register")
	@GetMapping("/register")
	public String register(RegisterForm registerForm, Model model) {
		return "register";
	}
	
	@PostMapping("/register")
	public String regsiterExec(
			@Validated RegisterForm registerForm,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "register";
		}
		Person p = new Person();
		p.setName(registerForm.getName());
		p.setAge(registerForm.getAge());
		p.setEmail(registerForm.getEmail());
		repository.saveAndFlush(p);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String update(
			UpdateForm updateForm,
			@RequestParam("id") int id,
			Model model) {
		List<Person> list = repository.findById(id);
//		model.addAttribute("updateForm", list);
		updateForm.setId(list.get(0).getId());
		updateForm.setName(list.get(0).getName());
		updateForm.setAge(list.get(0).getAge());
		updateForm.setEmail(list.get(0).getEmail());
		return "update";
	}
	
	@PostMapping("/update")
	public String updateExec(
			@Validated UpdateForm updateForm,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "update";
		}
		Person p = new Person();
		p.setId(updateForm.getId());
		p.setName(updateForm.getName());
		p.setAge(updateForm.getAge());
		p.setEmail(updateForm.getEmail());
		System.out.println("id: " + p.getId());
		System.out.println("name: " + p.getName());
		repository.saveAndFlush(p);
		return "redirect:/";		
	}
	
	@GetMapping("/delete")
	public String delete(
			DeleteForm deleteForm,
			@RequestParam("id") int id,
			Model model) {
		List<Person> list = repository.findById(id);
		deleteForm.setId(list.get(0).getId());
		deleteForm.setName(list.get(0).getName());
		deleteForm.setAge(list.get(0).getAge());
		deleteForm.setEmail(list.get(0).getEmail());
		return "delete";
	}
	
	@PostMapping("/delete")
	public String deleteExec(
			DeleteForm deleteForm,
			Model model) {
		System.out.println("id: " + deleteForm.getId());
		repository.deleteById(deleteForm.getId());
		return "redirect:/";
	}
}
