package array;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		char[][] m = {
				{'1', '1', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '1', '0', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '1', '1', '1', '1'}};
		System.out.println(maximalRectangle(m));

	}
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
        	if (matrix[0][i] == '1') {
        		dp[0][i] = 1;
        	} else {
        		dp[0][i] = 0;
        	}
        }
        if (rows > 1) {
        	for (int i = 1; i < rows; i++) {
        		for (int j = 0; j < cols; j++) {
        			if (matrix[i][j] == '0') {
        				dp[i][j] = 0;
        			} else {
        				dp[i][j] = dp[i - 1][j] + 1;
        			}
        		}
        	}
        }
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
        	maxArea = Math.max(maxArea, largestRectangleArea(dp[i]));
        }
        return maxArea;
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
