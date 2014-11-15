package array;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int len = 20;
		int[] num = new int[len];
		int seed = 9;
		for (int i = 0; i < len; i++) {
			num[i] = (i + seed) % len;
			System.out.print(num[i] + ", ");
		}
		System.out.println();
		System.out.println("minimum is: " + findValue(num, 21));
	}

	public static int findValue(int[] A, int target) {
		if (A.length == 0) {
			return -1;
		}
		int left = 0;
		int right = A.length - 1;
		int mid = (left + right) / 2;
		if (A[mid] == target) {
			return mid;
		}
		while (right - left > 1) {
			if (A[mid] > A[0]) {
				if (target > A[mid] || target < A[left]) {
					left = mid;
				} else {
					right = mid;
				}
			} else {
				if (target < A[mid] || target > A[right]) {
					right = mid;
				} else {
					left = mid;
				}
			}
			mid = (left + right) / 2;
			if (A[mid] == target) {
				return mid;
			}
		}
		if (A[right] == target) {
			return right;
		} else {
			return -1;
		}
	}
}
