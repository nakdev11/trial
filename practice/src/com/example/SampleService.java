package com.example;

public class SampleService {

	SampleDao dao = new SampleDao();

	public Item selectByName(String name) {

		return dao.selectByName("apple");

	}




}
