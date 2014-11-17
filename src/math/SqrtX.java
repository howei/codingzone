package math;

public class SqrtX {

	public static void main(String[] args) {
		System.out.println(sqrt(2147483647));
	}
    public static int sqrt(int x) {
    	if (x == 0 || x == 1) {
    		return x;
    	}
    	
    	long sqrt = 10;
    	long low = 0;
    	long high = x;
    	while (high - low > 1) {
    		if (sqrt * sqrt > x) {
    			high = sqrt;
    			sqrt = (high + low)/2;
    		} else if (sqrt * sqrt < x) {
    			low = sqrt;
    			sqrt = (low + high)/2;
    		} else {
    			return (int)sqrt;
    		}
    	}
    	return (int)sqrt;
    }
}
