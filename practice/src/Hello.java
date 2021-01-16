import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hello {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();
		System.out.println(now);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate targetDate = LocalDate.parse("20201227", formatter);
		System.out.println(targetDate);

	}

}
