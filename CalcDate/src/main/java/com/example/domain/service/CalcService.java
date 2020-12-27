package com.example.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.CalcResult;
import com.example.domain.model.DateFormula;
import com.example.domain.repository.DateFormulaMapper;

@Service
public class CalcService {

	@Autowired
	DateFormulaMapper dateFormulaMapper;
	
	// 計算式を戻す
	public List<DateFormula> selectMany() {
		List<DateFormula> list = dateFormulaMapper.selectMany();
		return list;
	}
	
	// 基準日から計算結果を戻す
	public List<CalcResult> calc(LocalDate date) {
				
		List<CalcResult> calcResults = new ArrayList<>();
		
		List<DateFormula> data = this.selectMany();

		for (DateFormula d : data) {

			CalcResult calcResult = new CalcResult();
			
			calcResult.setDateId(d.getDateId());
			calcResult.setDateName(d.getDateName());
			LocalDate resultDate = date.plusYears(d.getCalcValueY()).plusMonths(d.getCalcValueM()).plusDays(d.getCalcValueD());
			calcResult.setResultDate(resultDate);
			calcResult.setFormula(d.getCalcValueY() + "/" + d.getCalcValueM() + "/" + d.getCalcValueD());
//			System.out.println(calcResult.toString());
			calcResults.add(calcResult);
		}
		
		return calcResults;
		
	}
	
	public boolean insertOne(DateFormula dateFormula) {
		boolean ret = dateFormulaMapper.insertOne(dateFormula);
		return ret;
	}
	
	public boolean updateOne(DateFormula dateFormula) {
		boolean ret = dateFormulaMapper.updateOne(dateFormula);
		return ret;
	}
	
	public DateFormula selectOne(String dateId) {
		return dateFormulaMapper.selectOne(dateId);
	}

	public boolean deleteOne(String dateId) {
		boolean ret = dateFormulaMapper.deleteOne(dateId);
		return ret;
	}
	
}
