package other;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static String largestNumber(int[] num) {
    	Integer[] num0 = new Integer[num.length];
    	for (int i = 0; i < num.length; i++) {
    		num0[i] = num[i];
    	}
        Arrays.sort(num0, new Comparator<Integer>(){
        	@Override
        	   public int compare(Integer num1, Integer num2) {
        		String str1 = num1 + "" + num2;
        		String str2 = num2 + "" + num1;
        		if (str1.compareTo(str2) > 0) {
        			return 1;
        		} else if (str1.compareTo(str2) < 0) {
        			return -1;
        		}
        		return 0;
               }
        });
        String str = "";
        for (int i = num0.length - 1; i >= 0; i--) {
        	str += num0[i];
        }
        if (str.charAt(0) == '0') {
        	str = "0";
        }
        return str;
    }
}
