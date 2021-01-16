package practice.junit18_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("18.1 状態を持たないメソッドのテスト")
class StringUtilsTest extends StringUtils {

	@Test
	@DisplayName("aaa->aaaを返す")
	void test() {
		String expected = "aaa";
		String actual = StringUtils.toSnakeCase("aaa");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("HelloWorld->hello_worldを返す")
	void test2() {
		String expected = "hello_world";
		String actual = StringUtils.toSnakeCase("HelloWorld");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("practiceJunit->practice_junitを返す")
	void test3() {
		String expected = "practice_junit";
		String actual = StringUtils.toSnakeCase("practiceJunit");
		assertEquals(expected, actual);
	}

}
