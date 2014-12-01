package array;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] height = {2,1,2};
		System.out.println(largestRectangleArea(height));
	}
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
        	return 0;
        } else if (height.length == 1) {
        	return height[0];
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
        	if (stack.isEmpty() || height[i] >= stack.peek()) {
        		stack.push(height[i]);
        	} else {
        		int count = 0;
        		while (!stack.isEmpty() && height[i] < stack.peek()) {
        			count++;
        			maxArea = Math.max(maxArea, stack.peek() * count);
        			stack.pop();
        		}
        		for (int j = 0; j <= count; j++) {
        			stack.push(height[i]);
        		}
        	}
        }
        
        int ind = height.length - 1;
        while (!stack.isEmpty()) {
        	maxArea = Math.max(maxArea, stack.peek() * (height.length - ind));
        	ind--;
        	stack.pop();
        }
        return maxArea;
    }
}
