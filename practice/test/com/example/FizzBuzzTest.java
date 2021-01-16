package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FizzBuzzTest extends FizzBuzz {

	FizzBuzz fizzBuzz = new FizzBuzz();

	@Test
	void fizz() {
		assertEquals("Fizz", fizzBuzz(3));
		assertEquals("Fizz", fizzBuzz(18));
		assertEquals("Fizz", fizzBuzz(99));
	}
	@Test
	void buzz() {
		assertEquals("Buzz", fizzBuzz(5));
		assertEquals("Buzz", fizzBuzz(10));
		assertEquals("Buzz", fizzBuzz(95));
	}
	@Test
	void fizzbuzz() {
		assertEquals("FizzBuzz", fizzBuzz(0));
		assertEquals("FizzBuzz", fizzBuzz(15));
		assertEquals("FizzBuzz", fizzBuzz(90));
	}
	@Test
	void number() {
		assertEquals("1", fizzBuzz(1));
		assertEquals("4", fizzBuzz(4));
		assertEquals("98", fizzBuzz(98));
	}

}
