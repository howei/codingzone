package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations("02321445"));
	}
	
    public static List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<String>();
    	if (digits.length() <= 0) {
    		res.add("");
    		return res;
    	}
    	
    	String d = "";
    	for (int i = 0; i < digits.length(); i++) {
    		if (digits.charAt(i) - '0' != 0 && digits.charAt(i) - '0' != 1) {
    			d += digits.charAt(i);
    		}
    	}
    	if (d.length() <= 0) {
    		res.add("");
    		return res;
    	}

        return comb(d);
    }
    
    public static List<String> comb(String digits) {
    	List<String> res = new ArrayList<String>();
    	int dLength = digits.length();
    	char first = digits.charAt(0);
    	String letters = digitToString(first - '0');
    	int len = letters.length();
    	
    	if (dLength == 1) {
    			for (int i = 0; i < len; i++) {
    				String tmp = "";
    				tmp += letters.charAt(i);
    				res.add(tmp);
    			}
    		return res;
    	}

    	List<String> remd = comb(digits.substring(1, dLength));
    	for (String item : remd) {
    		for (int i = 0; i < len; i++) {
    			String str = letters.charAt(i) + item;
    			res.add(str);
    		}
    	}
    	return res;
    }
    
    public static String digitToString(int d) {
    	String result = null;
    	switch (d) {
    	case 1 : 
    		result =  "";
    		break;
    	case 2 : 
    		result =  "abc";
    		break;
    	case 3 :
    		result =  "def";
    		break;
    	case 4 :
    		result =  "ghi";
    		break;
    	case 5 :
    		result =  "jkl";
    		break;
    	case 6 :
    		result =  "mno";
    		break;
    	case 7 :
    		result =  "pqrs";
    		break;
    	case 8 :
    		result =  "tuv";
    		break;
    	case 9 :
    		result =  "wxyz";
    		break;
    	case 0 :
    		result =  "";
    		break;
    	}
    	return result;
    }
}
