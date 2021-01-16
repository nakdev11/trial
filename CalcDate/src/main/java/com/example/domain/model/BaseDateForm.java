package com.example.domain.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class BaseDateForm {

	@NotNull
	@DateTimeFormat(pattern="yyyy/M/d")
	private LocalDate baseDate;

	public LocalDate getBaseDate() {
		return baseDate;
	}

	public void setBaseDate(LocalDate baseDate) {
		this.baseDate = baseDate;
	}
	
}
