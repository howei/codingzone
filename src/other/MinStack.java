package other;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
    public void push(int x) {
        if (stack.isEmpty() || x <= minStack.peek()) {
        	minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
    	if (minStack.peek().equals(stack.peek())) {
    		minStack.pop();
    	}
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
