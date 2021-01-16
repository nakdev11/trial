package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void case1_1_multiply正x正の結果() {
		Calculator calc = new Calculator();
		int expected = 12;
		int actual = calc.multiply(3, 4);
		assertEquals(expected, actual);
	}

	@Test
	void case1_2_multiply正x負の結果() {
		Calculator calc = new Calculator();
		int expected = -14;
		int actual = calc.multiply(2, -7);
		assertEquals(expected, actual);
	}

	@Test
	void case1_3_multiply負x負の結果() {
		Calculator calc = new Calculator();
		int expected = 35;
		int actual = calc.multiply(-5, -7);
		assertEquals(expected, actual);
	}

	@Test
	void case1_4_multiply正x0の結果() {
		Calculator calc = new Calculator();
		int expected = 0;
		int actual = calc.multiply(999, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	void case2_1_divideの結果() {
		Calculator calc = new Calculator();
		double expected = 1.5;
		double actual = calc.divide(3, 2);
		assertEquals(expected, actual);
		
	}

	@Test
	void case2_2_divideの結果() {
		Calculator calc = new Calculator();
		assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0)); 
	}
}
