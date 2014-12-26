package other;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        int length = tokens.length;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < length; i++) {
        	if (!tokens[i].equals("+") && !tokens[i].equals("-")
        			&& !tokens[i].equals("*") && !tokens[i].equals("/")) {
        		stack.push(Integer.valueOf(tokens[i]));
        	} else {
        		int num1 = stack.pop();
        		int num2 = stack.pop();
        		int res = 0;
        		if (tokens[i].equals("+")) {
        			res = num2 + num1;
        		} else if (tokens[i].equals("-")) {
        			res = num2 - num1;
        		} else if (tokens[i].equals("*")) {
        			res = num2 * num1;
        		} else if (tokens[i].equals("/")) {
        			res = num2/num1;
        		}
        		stack.push(res);
        	}
        }
        return stack.pop();
    }
}
