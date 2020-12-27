package com.example.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.model.DateFormula;

@Mapper
public interface DateFormulaMapper {

	public DateFormula selectOne(String dateId);

	public List<DateFormula> selectMany();
	
	public boolean insertOne(DateFormula dateFormula);
	
	public boolean updateOne(DateFormula dateFormula);
	
	public boolean deleteOne(String dateId);
	
	
	
}
