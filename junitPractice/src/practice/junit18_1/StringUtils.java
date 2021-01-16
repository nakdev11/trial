package practice.junit18_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static String toSnakeCase(String str) {

		if (str == null) {
			throw new NullPointerException("引数がnullです");
		}

		String snake = str;
		Pattern p = Pattern.compile("([A-Z])");
		for (;;) {
			Matcher m = p.matcher(snake);
			if (!m.find()) break;
			snake = m.replaceFirst("_" + m.group(1).toLowerCase());
		}
		return snake.replaceFirst("^_", "");
	}

}
