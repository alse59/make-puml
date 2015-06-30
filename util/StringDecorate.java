package util;

public class StringDecorate {
	public static String addTag(String target) {
		if (target == null) return null;
		return "{" + target + "}";
	}
}
