package practice.junit18_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("18.5 void型を戻り値とするメソッドのテスト")
class ItemStockTest2 extends ItemStock {

	@DisplayName("初期状態の場合")
	class ItemStockTest21 {

		ItemStock sut;
		Item book;

		@BeforeEach
		void setUp() {
			sut = new ItemStock();
			book = new Item("book", 3800);
		}

		@Test
		@DisplayName("初期状態で、getNumで0が取得出来る")
		void test1() {
			int expected = 0;
			int actual = sut.getNum(book);
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("初期状態で、addでItemを追加すると、getNumで1が取得出来る")
		void test2() {
			int expected = 1;
			sut.add(book);
			int actual = sut.getNum(book);
			assertEquals(expected, actual);
		}

	}

	@DisplayName("bookが1回追加されている場合")
	class ItemStockTest22 {

		ItemStock sut;
		Item book;
		Item pen;

		@BeforeEach
		void setUp() {
			sut = new ItemStock();
			book = new Item("book", 3800);
			pen = new Item("pen", 120);
			sut.add(book);
		}

		@Test
		@DisplayName("Itemが1つ追加されている状態で、addで同じItemを追加すると、getNumで2が取得出来る")
		void test1() {
			int expected = 2;
			sut.add(book);
			int actual = sut.getNum(book);
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Itemが1つ追加されている状態で、addで違うItemを追加すると、getNumで1が取得出来る")
		void test2() {
			int expected = 1;
			sut.add(pen);
			int actual = sut.getNum(book);
			assertEquals(expected, actual);
		}

	}


}
