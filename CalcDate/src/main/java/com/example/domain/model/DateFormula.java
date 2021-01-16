package com.example.domain.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DateFormula {
	
	@NotNull
	private String dateId;
	
	@NotBlank
	private String dateName;
	
	@Min(-100)
	@Max(100)
	private int calcValueY;
	
	@Min(-12)
	@Max(12)
	private int calcValueM;
	
	@Min(-365)
	@Max(365)
	private int calcValueD;
	
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
	public int getCalcValueY() {
		return calcValueY;
	}
	public void setCalcValueY(int calcValueY) {
		this.calcValueY = calcValueY;
	}
	public int getCalcValueM() {
		return calcValueM;
	}
	public void setCalcValueM(int calcValueM) {
		this.calcValueM = calcValueM;
	}
	public int getCalcValueD() {
		return calcValueD;
	}
	public void setCalcValueD(int calcValueD) {
		this.calcValueD = calcValueD;
	}
	
//	@Override
//	public String toString() {
//		return "DateFormula [dateId=" + dateId + ", dateName=" + dateName + ", calcValueY=" + calcValueY
//				+ ", calcValueM=" + calcValueM + ", calcValueD=" + calcValueD + "]";
//	}
	
	
}
