package com.example.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.domain.model.BaseDateForm;
import com.example.domain.model.CalcResult;
import com.example.domain.model.DateFormula;
import com.example.domain.service.CalcService;

@Controller
@SessionAttributes("sessionBaseDate")
public class CalcController {

	@Autowired
	CalcService calcService;
	
	@GetMapping("/calc")
	public String getCalc(@ModelAttribute BaseDateForm form, Model model) {
		LocalDate baseDate;
		if (model.getAttribute("sessionBaseDate") != null) {
			baseDate = (LocalDate)model.getAttribute("sessionBaseDate");			
		} else {
			baseDate = LocalDate.now();			
		}
		form.setBaseDate(baseDate);
		List<CalcResult> calcResults = calcService.calc(baseDate);
		model.addAttribute("calcResults", calcResults);
		return "calc";
	}
	
	@PostMapping("/calc")
	public String postCalc(
			@ModelAttribute @Validated BaseDateForm form,
			BindingResult result,
			Model model) {
		
		if (result.hasErrors()) {
			return "calc";
		}
		
		System.out.println(form.getBaseDate());
		List<CalcResult> calcResults = calcService.calc(form.getBaseDate());
		model.addAttribute("calcResults", calcResults);
		model.addAttribute("baseDate", form.getBaseDate());
		
		return "calc";
	}
	
	@GetMapping("/register")
	public String getRegister(@ModelAttribute DateFormula dateFormula, Model model) {
//		model.addAttribute("dateFormula", dateFormula); // これ書かないとバリデーション効かない?
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegister(
			@ModelAttribute @Validated DateFormula dateFormula,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "register";
		}
		calcService.insertOne(dateFormula);
		return "redirect:calc";
	}
	
	@GetMapping("/update")
	public String getUpdate(
			@RequestParam("dateId") String dateId,
			Model model) {
		model.addAttribute("dateFormula", calcService.selectOne(dateId));
		return "update";
	}
	
	@PostMapping("/update")
	public String postUpdate(
			@ModelAttribute @Validated DateFormula dateFormula,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "update";
		}
		calcService.updateOne(dateFormula);
		return "redirect:calc";
	}
	
	@GetMapping("/delete")
	public String getDelete(
			@RequestParam("dateId") String dateId,
			Model model) {
		model.addAttribute("dateFormula", calcService.selectOne(dateId));
		return "delete";
	}
	
	@PostMapping("/delete")
	public String postDelete(@RequestParam("dateId") String dateId, Model model) {
		try { 
			calcService.deleteOne(dateId);		
		} catch (Exception e) {
			System.out.println("delete失敗: " + e);
		}
		return "redirect:calc";
	}
	
}
