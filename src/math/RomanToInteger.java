package math;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("MIC"));

	}
    public static int romanToInt(String s) {
        int prev = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
        	int curr = charToInt(s.charAt(i));
        	if (prev < curr) {
        		result += curr - 2 * prev;
        	} else {
        		result += curr;
        	}
    		prev = curr;
        }
        return result;
    }
    public static int charToInt(char c) {
    	int i = 0;
    	switch (c) {
    	case 'I' : i = 1;
    	break;
    	case 'V' : i = 5;
    	break;
    	case 'X' : i = 10;
    	break;
    	case 'L' : i = 50;
    	break;
    	case 'C' : i = 100;
    	break;
    	case 'D' : i = 500;
    	break;
    	case 'M' : i = 1000;
    	break;
    	}
    	return i;
    }
}
