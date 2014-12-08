package string;

public class ValidNumber {

	public static void main(String[] args) {
		System.out.println(isNumber("...1e00"));

	}

	public static boolean isNumber(String s) {
		if (s == null) {
			return false;
		}
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}

		int indSign = -1;
		int indE = -1;
		int indDot = -1;

		int len = s.length();
		// skip leading sign
		if (s.charAt(0) == '+' || s.charAt(0) == '-') {
			s = s.substring(1, len);
			len = s.length();
		}
		if (0 == len) {
			return false;
		}

		for (int i = 0; i < len; i++) {
			if ((s.charAt(i) == 'E' || s.charAt(i) == 'e') && indE == -1) {
				if (i == 0) {
					return false;
				}
				indE = i;
			} else if (s.charAt(i) == '.' && indDot == -1) {
				indDot = i;
			} else if ((s.charAt(i) == '+' || s.charAt(i) == '-')
					&& indSign == -1) {
				if (i == 0) {
					return false;
				}
				indSign = i;
			} else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				return false;
			}
		}
		if ((indE > 0 && indE < indDot) || (indSign > 0 && indSign - indE != 1)
				|| indE == len - 1 || indSign == len - 1) {
			return false;
		}
		if (indDot == 0
				&& (len == 1 || s.charAt(indDot + 1) < '0' || s
						.charAt(indDot + 1) > '9')) {
			return false;
		} else if (indDot == len - 1
				&& (s.charAt(indDot - 1) < '0' || s.charAt(indDot - 1) > '9')) {
			return false;
		} else if (indDot > 0 && indDot < len - 1
				&& (s.charAt(indDot - 1) < '0' || s.charAt(indDot - 1) > '9')
				&& (s.charAt(indDot + 1) < '0' || s.charAt(indDot + 1) > '9')) {
			return false;
		}

		return true;
	}
}
