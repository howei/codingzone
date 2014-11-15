package array;

public class RemoveDuplicatesII {

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 6, 6, 6, 6, 7 };

/*		for (int i = 0; i < B.length; i++) {
			System.out.print(B[i] + ", ");
		}*/
		System.out.println(removeDuplicates(A));
	}

	public static int removeDuplicates(int[] A) {
		int size = A.length;
		if (size >= 0 && size <= 2) {
			return size;
		}

		int pre = 0;
		int cur = 1;
		int p = 2;
		while (p < size) {
			if (A[p] != A[pre]) {
				A[cur + 1] = A[p];
				cur++;
				pre++;
				p++;
			} else {
				p++;
			}
		}


		return pre + 2;
		//return A;
	}
}
