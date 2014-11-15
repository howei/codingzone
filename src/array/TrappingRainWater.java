package array;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}
    public static int trap(int[] A) {
        int size = A.length;
        if (size < 3) {
        	return 0;
        }
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        
        leftMax[0] = A[0];
        for (int i = 1; i < size; i++) {
        	leftMax[i] = Math.max(leftMax[i - 1], A[i]);
        }
        
        int vol = 0;
        rightMax[size - 1] = A[size - 1];
        for (int i = size - 2; i > 0; i--) {
        	rightMax[i] = Math.max(rightMax[i + 1], A[i]);
        	if (Math.min(rightMax[i + 1], leftMax[i - 1]) > A[i]) {
        		vol += Math.min(rightMax[i + 1], leftMax[i - 1]) - A[i];
        	}
        }
        return vol;
    }
}
