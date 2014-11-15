package array;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 0, 1, -5, 4 };
		//int[] A = { 2, 3, -2 ,4 };
		System.out.println(maxProduct(A));
	}

	public static int maxProduct(int[] A) {
		int size = A.length;
		if (size == 0) {
			return 0;
		} else if (size == 1) {
			return A[0];
		}
		int min = A[0];
		int max = A[0];
		int mProd = A[0];
		
		for (int i = 1; i < size; i++) {
			int tmp1 = max * A[i];
			int tmp2 = min * A[i];
			max = Math.max(Math.max(tmp1, tmp2), A[i]);
			min = Math.min(Math.min(tmp1, tmp2), A[i]);
			if (mProd < max) {
				mProd = max;
			}
		}
		return mProd;
	}
}
