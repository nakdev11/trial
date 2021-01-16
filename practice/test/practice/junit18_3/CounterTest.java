package practice.junit18_3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("18.3 副作用を持つメソッドのテスト")
class CounterTest extends Counter {

	Counter sut;

	@BeforeEach
	public void setUp() {
		sut = new Counter();
	}

	@Test
	@DisplayName("初期状態で実行すると1を取得する")
	void test() {
		int expected = 1;
		int actual = sut.increment();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("1回実行した状態で実行すると2を取得する")
	void test2() {
		int expected = 2;
		sut.increment();
		int actual = sut.increment();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("50回実行した状態で実行すると51を取得する")
	void test3() {
		int expected = 51;
		for (int i = 0; i < 50; i++) {
			sut.increment();
		}
		int actual = sut.increment();
		assertEquals(expected, actual);
	}
}
