package array;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 6, 6, 6, 6, 7 };
		System.out.println(removeDuplicates(A));

	}

	public static int removeDuplicates(int[] A) {
		int size = A.length;
		if (size == 0 || size == 1) {
			return size;
		}

		int low = 0;
		for (int i = 1; i < size; i++) {
			if (A[i] != A[low]) {
				A[low + 1] = A[i];
				low++;
			}
		}

		return low + 1;
	}
}
