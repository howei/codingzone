package math;

public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("408", "5"));

	}

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		String prod = "";
		String trailingZeros1 = "";
		String trailingZeros2 = "";
		int size1 = num1.length();
		int size2 = num2.length();
		for (int i = size1 - 1; i >= 0; i--) {
			if (num1.charAt(i) - '0' == 0) {
				num1 = num1.substring(0, size1 - 1);
				trailingZeros1 += "0";
			} else {
				break;
			}
		}
		for (int i = size2 - 1; i >= 0; i--) {
			if (num2.charAt(i) - '0' == 0) {
				num2 = num2.substring(0, size2 - 1);
				trailingZeros2 += "0";
			} else {
				break;
			}
		}
		size1 = num1.length();
		size2 = num2.length();

		int[] intmid = new int[size1 + size2];
		for (int j = size1 - 1; j >= 0; j--) {
			for (int i = size2 - 1; i >= 0; i--) {
				intmid[j + i] += (num1.charAt(j) - '0')
						* (num2.charAt(i) - '0');
			}
		}
		int i;
		for (i = size1 + size2 - 1; i >= 0; i--) {
			if (intmid[i] == 0) {
			} else {
				break;
			}
		}
		int carry = 0;
		for (; i >= 0; i--) {
			prod = String.valueOf((intmid[i] + carry) % 10) + prod;
			carry = (intmid[i] + carry) / 10;
		}
		if (carry != 0) {
			prod = String.valueOf(carry) + prod;
		}
		prod = prod + trailingZeros1 + trailingZeros2;
		return prod;
	}
}
