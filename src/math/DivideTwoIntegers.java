package math;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divide(2147483647, 1));

	}

	public static int divide(int dividend, int divisor) {
		long x = (long) dividend;
		long y = (long) divisor;
		int sign1 = 1;
		int sign2 = 1;
		int result = 0;
		if (x < 0) {
			sign1 = -1;
			x = -x;
		}
		if (y < 0) {
			sign2 = -1;
			y = -y;
		}
		if (x < y) {
			return 0;
		}
		int sign = sign1 * sign2;

		long m = 1;
		while (x - m * y >= 0) {
			x -= m * y;
			result += m;
			m += m;
		}

		while (x - y >= 0) {
			m >>= 1;
		    if (x - m * y >= 0) {
				x -= m * y;
				result += m;
		    }
		    if (m == 0) {
		    	break;
		    }
		}

		return result * sign;
	}
}
