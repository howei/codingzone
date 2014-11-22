package string;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "[{[]}]";
		System.out.println(isValid(s));

	}
    public static boolean isValid(String s) {
        if (s == null) {
        	return false;
        }
        
        int len = s.length();
        if (len == 0 || len % 2 == 1) {
        	return false;
        }
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < len; i++) {
        	if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        		stack.push(s.charAt(i));
        	} else if (s.charAt(i) == ')') {
        		if (stack.empty() || stack.peek() != '(') {
        			return false;
        		}
        		stack.pop();
        	} else if (s.charAt(i) == ']') {
        		if (stack.empty() || stack.peek() != '[') {
        			return false;
        		}
        		stack.pop();
        	} else if (s.charAt(i) == '}') {
        		if (stack.empty() || stack.peek() != '{') {
        			return false;
        		}
        		stack.pop();
        	}
        }
        if (stack.empty()) {
        	return true;
        }
        return false;
    }
}
