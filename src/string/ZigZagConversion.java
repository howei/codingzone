package string;

public class ZigZagConversion {

	public static void main(String[] args) {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int nRows = 3;
		System.out.println(convert(s, nRows));

	}

	public static String convert(String s, int nRows) {
		if (s == null || s.length() == 0 || s.length() == 1 || nRows <= 1) {
			return s;
		}

		String r = "";
		int len = s.length();
		int j = 0;
		while (j < len) {
			r += s.charAt(j);
			j += 2 * (nRows - 1);
		}

		if (nRows > 2) {
			for (int i = 1; i < nRows - 1; i++) {
				j = i;
				while (j < len) {
					r += s.charAt(j);
					j += 2 * (nRows - i - 1);
					if (j < len) {
						r += s.charAt(j);
						j += 2 * i;
					}
				}
			}
		}
		
		j = nRows - 1;
		while (j < len) {
			r += s.charAt(j);
			j += 2 * (nRows - 1);
		}
		return r;
	}
}
