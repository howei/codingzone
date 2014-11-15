package array;

public class JumpGameII {

	public static void main(String[] args) {
		int[] A = { 2, 3, 1, 1, 4 };
		System.out.println(jump(A));
	}

	public static int jump(int[] A) {
		int size = A.length;
		if (size <= 1) {
			return 0;
		}
		
		int start = 0;
		int end = 0;
		int maxReach = 0;
		int step = 0;
		while (end < size - 1) {
			step++;
			for (int i = start; i <= end; i++) {
				if (A[i]  + i > maxReach) {
					maxReach = A[i] + i;
				}
				if (maxReach >= size - 1) {
					return step;
				}
			}
			start = end + 1;
			end = maxReach;
		}
		return 0;
	}
}
