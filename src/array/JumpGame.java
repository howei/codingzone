package array;

public class JumpGame {

	public static void main(String[] args) {
		int[] A = { 3, 0, 2, 0, 4 };
		System.out.println(canJump(A));
	}

	public static boolean canJump(int[] A) {
		int size = A.length;
		if (size == 1) {
			return true;
		}

		int couldReach = 0;
		int stepsRem = 0;
		for (int i = 0; i < size; i++) {
			couldReach = Math.max(A[i] + i, couldReach);
			stepsRem = Math.max(A[i], stepsRem - 1);
			if (couldReach >= size - 1 && stepsRem > 0) {
				return true;
			}
			if (stepsRem == 0 && i != size - 1) {
				return false;
			}
		}
		return true;
	}
}
