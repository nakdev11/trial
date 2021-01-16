package com.example;

public class FizzBuzz {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			System.out.println(fizzBuzz(i));
		}


	}

	static String fizzBuzz(int x) {

		String out = "";

		if (x % 3 == 0) {
			out += "Fizz";
		}

		if (x % 5 == 0) {
			out += "Buzz";
		}

		if ( x % 3 == 0 || x % 5 == 0) {
			return out;
		}  else {
			return "" +x;
		}

	}
}
