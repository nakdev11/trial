package practice.junit19_1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class FizzBuzzTest extends FizzBuzz {

	@Test
	void test() {
		List<String> actual = FizzBuzz.createFizzBuzzList(16);
		assertEquals("1", actual.get(0));
		assertEquals("2", actual.get(1));
		assertEquals("Fizz", actual.get(2));
		assertEquals("4", actual.get(3));
		assertEquals("Buzz", actual.get(4));
		assertEquals("Fizz", actual.get(5));
		assertEquals("7", actual.get(6));
		assertEquals("8", actual.get(7));
		assertEquals("Fizz", actual.get(8));
		assertEquals("Buzz", actual.get(9));
		assertEquals("11", actual.get(10));
		assertEquals("Fizz", actual.get(11));
		assertEquals("13", actual.get(12));
		assertEquals("14", actual.get(13));
		assertEquals("FizzBuzz", actual.get(14));
		assertEquals("16", actual.get(15));
	}

}
