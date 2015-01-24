package string;

import java.util.Stack;

public class LongestValidParentheses {
	/**
	 * Revisit later for the DP solution.
	 * @param s
	 * @return
	 */
    public static int longestValidParentheses(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') {
        		stack.push(i);
        	} else {
        		if (!stack.empty() && s.charAt(stack.peek()) == '(') {
        			stack.pop();
        			int left = stack.empty()? -1 : stack.peek();
        			max = Math.max(max, i - left);
        		} else {
        			stack.push(i);
        		}
        	}
        }
        return max;
    }
}
