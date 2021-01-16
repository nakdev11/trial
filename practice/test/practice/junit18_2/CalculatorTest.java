package practice.junit18_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("18.2 例外を送出するメソッドのテスト")
class CalculatorTest extends Calculator {

	@Test
	@DisplayName("１０を２で割ると５となる")
	void test() {
		int expected = 5;
		Calculator sut = new Calculator();
		int actual = sut.divide(10, 2);
		assertEquals(expected, actual);
	}
	@Test
	@DisplayName("第２引数が０である場合、IllegalArgumentExceptionを送出する")
	void test2() {
		Calculator sut = new Calculator();
		assertThrows(IllegalArgumentException.class, () -> sut.divide(10, 0));
	}

	@Test
	@DisplayName("第２引数が０である場合、例外メッセージを表示する")
	void test3() {
		Calculator sut = new Calculator();
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> sut.divide(10, 0));
		assertEquals("0で割れません", exception.getMessage());
	}


}
