import java.util.Optional;

public class Test {

	public static void main(String[] args) {
		
//		String str = null;
		String str = "abcdefg";
		
//		System.out.println(str.length());

		Optional<String> strOpt = Optional.ofNullable(str);
		
		if (strOpt.isPresent()) {
			String msg = strOpt.get();
			System.out.println(msg.length());
		} else {
			System.out.println("nullです");
		}
		
	}
}
