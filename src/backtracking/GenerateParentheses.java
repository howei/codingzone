package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(0));

	}
	
    public static List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<String>();
        if (n < 0) {
        	return res;
        }
        
        String entry = "";
        gen(res, entry, n, n);
        return res;
    }
    
    public static void gen(List<String>res, String entry, int left, int right) {
    	if (left == 0 && right == 0) {
    		res.add(entry);
    	} else if (left == right) {
    		entry += "(";
    		gen(res, entry, left - 1, right);
    	}
     	
    	if (left < right && left > 0) {
    		entry += "(";
    		gen(res, entry, left - 1, right);
    		entry = entry.substring(0, entry.length() - 1);
    		entry += ")";
    		gen(res, entry, left, right - 1);
    	}
    	if (left < right && left == 0) {
    		entry += ")";
    		gen(res, entry, left, right - 1);
    	}
    	
    	
    }
}
