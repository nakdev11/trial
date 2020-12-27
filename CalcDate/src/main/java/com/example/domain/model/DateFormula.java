package com.example.domain.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class DateFormula {
	
	@NotNull
	@NotBlank
	private String dateId;
	
	@NotNull
	@NotBlank
	private String dateName;
	
	@Min(0)
	@Max(9999)
	private int calcValueY;
	
	@Min(0)
	@Max(9999)
	private int calcValueM;
	
	@Min(0)
	@Max(9999)
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
