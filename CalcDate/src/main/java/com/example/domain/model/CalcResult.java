package com.example.domain.model;

import java.time.LocalDate;

public class CalcResult {

	private String dateId;
	private String dateName;
	private LocalDate resultDate;
	private String formula;
	
	public String getDateId() {
		return dateId;
	}
	public void setDateId(String dateId) {
		this.dateId = dateId;
	}
	public String getDateName() {
		return dateName;
	}
	public void setDateName(String dateName) {
		this.dateName = dateName;
	}
	public LocalDate getResultDate() {
		return resultDate;
	}
	public void setResultDate(LocalDate resultDate) {
		this.resultDate = resultDate;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	@Override
	public String toString() {
		return "CalcResult [dateId=" + dateId + ", dateName=" + dateName + ", resultDate=" + resultDate + ", formula="
				+ formula + "]";
	}
	
}
