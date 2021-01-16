package com.example;

import java.util.Date;

public class DateDependencyExample {

	Date date = new Date();

	public void doSomething() {
		this.date = new Date();

	}
}
