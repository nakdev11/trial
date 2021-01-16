package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class DateDependencyExampleTest extends DateDependencyExample {

	@Test
	void test() throws Exception {
		DateDependencyExample sut = new DateDependencyExample();
		sut.doSomething();
//		Thread.sleep(100);
		Date expected = new Date();
		assertEquals(expected, sut.date);
	}

}
