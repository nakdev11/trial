package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class SampleServiceTest extends SampleService {

	@Test
	void test() {
		Item item1 = new Item("apple", 100);
		Item item2 = new Item("banana", 80);

		SampleDao mock = mock(SampleDao.class);
		when(mock.selectByName("apple")).thenReturn(item1);
		when(mock.selectByName("banana")).thenReturn(item2);

		SampleService sut = new SampleService();
		String actualName = sut.selectByName("apple").getName();
		int actualPrice = sut.selectByName("apple").getPrice();

		assertEquals(actualName, "apple");
		assertEquals(actualPrice, 100);
	}

}
