package practice.junit19_1;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	static List<String> createFizzBuzzList(int num) {


		List<String> list = new ArrayList<>();

		for (int i = 1; i <= num; i++) {

			String res = "";

			if (i % 3 == 0) {
				res += "Fizz";
			}

			if (i % 5 == 0) {
				res += "Buzz";
			}

			if (i % 3 != 0 && i % 5 != 0) {
				res += i;
			}

			list.add(res);

		}

		return list;

	}

}
