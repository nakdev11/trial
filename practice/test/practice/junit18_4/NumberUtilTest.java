package practice.junit18_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("18.4 同値クラスに対するテスト")
class NumberUtilTest extends NumberUtil {

	@Test
	@DisplayName("10を与えるとtrueを返す")
	void test() {
		boolean expected = true;
		boolean actual = NumberUtil.isEven(10);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("7を与えるとfalseを返す")
	void test2() {
		boolean expected = false;
		boolean actual = NumberUtil.isEven(7);
		assertEquals(expected, actual);
	}

}
