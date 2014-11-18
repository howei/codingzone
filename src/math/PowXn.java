package math;

public class PowXn {

	public static void main(String[] args) {
		System.out.println(pow(3, -2));

	}
    public static double pow(double x, int n) {
        if (n < 0) {
        	return 1.0/power(x, -n);
        } else {
        	return power(x, n);
        }
    }
    public static double power(double x, int n) {
    	if (n == 0) {
    		return 1.0;
    	}
    	double p = power(x, n/2);
    	if (n % 2 == 0) {
    		return p*p;
    	} else {
    		return p*p*x;
    	}
    }
}
