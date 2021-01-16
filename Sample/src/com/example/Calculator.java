package com.example;

public class Calculator {

	int multiply(int x, int y) {
		return x * y;
	}
	
	double divide(double x, double y) {
		if (y == 0) {
			throw new IllegalArgumentException("divide by zero.");
		}
		return x / y;
	}
}
