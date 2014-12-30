package math;

public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        if (n <= 0) {
        	return 0;
        }
        
        int i = 5;
        int zeroes = 0;
        while (i <= n) {
        	zeroes += n/i;
        	i *= 5;
        }
        return zeroes;
    }
}
