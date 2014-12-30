package math;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
        	return "";
        } else if (numerator == 0) {
        	return "0";
        }
        String sign = "";
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
        	sign = "-";
        }
        long nume = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        String result = "" + nume/denom;
        long residual = nume%denom;
        if (residual == 0) {
        	return sign + result;
        }
        
        result += ".";
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (!map.containsKey(residual)) {
        	map.put(residual, result.length());
        	result += "" + residual*10/denom;
        	residual = (residual*10)%denom;
        	if (residual == 0) {
        		return sign + result;
        	}
        }
        
        result = result.substring(0, map.get(residual)) + "(" + result.substring(map.get(residual), result.length()) + ")";
        return sign + result;
    }
    
}
