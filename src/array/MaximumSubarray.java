package array;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(A));
	}
	
    public static int maxSubArray(int[] A) {
        int size = A.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < size; i++) {
        	sum += A[i];
        	max = Math.max(max, sum);
        	if (sum < 0) {
        		sum = 0;
        	}
        }
        return max;
    }
}
