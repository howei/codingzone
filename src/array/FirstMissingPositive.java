package array;

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] A = { -1, 4, 2, 1, 9, 10 };
		System.out.println(firstMissingPositive(A));
	}

	public static int firstMissingPositive(int[] A) {

		// move the negatives to end
		int size = A.length;
		int end = size - 1;
		while (end >= 0 && A[end] <= 0) {
			end--;
		}
		if (end >= 0) {
			for (int i = 0; i <= end; i++) {
				if (A[i] <= 0) {
					int tmp = A[i];
					A[i] = A[end];
					A[end] = tmp;
					end--;
				}
				while (end >= 0 && A[end] <= 0) {
					end--;
				}
			}
		} else {
			return 1; // all negative
		}
		
		// refill the array
		size = end + 1;
		for (int i = 0; i < size; i++) {
			int j = A[i] - 1;
			while (j >= 0 && j < size && A[j] != -1) {
				int tmp = A[j];
				A[j] = -1;
				j = tmp - 1;
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.println();
		
		// find the first missing positive
		for (int i = 0; i < size; i++) {
			if (A[i] != -1) {
				return i + 1;
			}
		}
		return size + 1;
	}

}
