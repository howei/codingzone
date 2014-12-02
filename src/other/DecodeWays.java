package other;

public class DecodeWays {

	public static void main(String[] args) {
		String s = "101";
		System.out.println(sDecodings(s));
	}

	public static int sDecodings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int len = s.length();
		if (s.charAt(0) == '0') {
			return 0;
		}
		int[] ways = new int[len + 1];
		if (s.charAt(len - 1) != '0') {
			ways[len - 1] = 1;
		} else {
			ways[len - 1] = 0;
		}
		if (len == 1) {
			return ways[0];
		}
		String tmp = "";
		tmp += s.charAt(len - 2);
		tmp += s.charAt(len - 1);
		if (s.charAt(len - 2) != '0' && Integer.parseInt(tmp) <= 26) {
			ways[len - 2] = ways[len - 1] + 1;
		} else if (s.charAt(len - 2) == '0') {
			ways[len - 2] = 0;
		} else {
			ways[len - 2] = ways[len - 1];
		}

		for (int i = len - 3; i >= 0; i--) {
			tmp = "";
			tmp += s.charAt(i);
			tmp += s.charAt(i + 1);
			if (s.charAt(i) != '0' && Integer.parseInt(tmp) <= 26) {
				ways[i] = ways[i + 1] + ways[i + 2];
			} else if (s.charAt(i) == '0') {
				ways[i] = 0;
			} else {
				ways[i] = ways[i + 1];
			}
		}
		return ways[0];
	}
}
