package math;

public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(atoi("       +10522545459 ui999ui  "));

	}
    public static int atoi(String str) {
        str = str.trim();
        int size = str.length();
        if(size == 0) {
        	return 0;
        }
        
        int sign = 1;
        int ind = 0;
        if (str.charAt(0) == '-') {
        	sign = -1;
        	ind++;
        } else if (str.charAt(0) == '+') {
        	ind++;
        }
        int num = 0;
        int i = ind;
        while (i < size) {
        	if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9) {
        		if (sign == 1 && num > (Integer.MAX_VALUE - (str.charAt(i) - '0')) / 10) {
        			return Integer.MAX_VALUE;
        		} else if (sign == -1 && num > -((Integer.MIN_VALUE + (str.charAt(i) - '0')) / 10)) {
        			return Integer.MIN_VALUE;
        		}
        		num = num * 10 + (str.charAt(i) - '0');
        	} else {
        		break;
        	}
        	i++;
        }
        return num * sign;
    }
}
