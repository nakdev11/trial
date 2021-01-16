package com.example;

public class SampleMain {

	public static void main(String[] args) {

		SampleService service = new SampleService();

		Item item = service.selectByName("apple");

		System.out.println(item.getName() + ":" + item.getPrice());

	}


}
