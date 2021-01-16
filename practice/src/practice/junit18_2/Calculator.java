package practice.junit18_2;

public class Calculator {

	public int divide(int x, int y) {

		if (y == 0) {
			throw new IllegalArgumentException("0で割れません");
		}

		return x / y;
	}

}
