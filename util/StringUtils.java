package util;

public class StringUtils {

	public static String reverse(String target) {
		if (target == null) {
			throw new NullPointerException("target is null");
		}
		StringBuilder sb = new StringBuilder();
		for (int strItr = 0;strItr < target.length(); strItr++) {
			sb.append(target.charAt(target.length()-strItr-1));
		}
		return sb.toString();
		
	}
}
