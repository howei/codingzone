package array;

public class SearchForARange {

	public static void main(String[] args) {
		int[] A = { 8, 8, 8, 8, 8, 8, 8, 10 };
		int target = 8;
		int[] result = searchRange(A, target);
		System.out.println("[" + result[0] + ", " + result[1] + "]");
	}

	public static int[] searchRange(int[] A, int target) {
		int size = A.length;
		int low = 0;
		int high = size - 1;
		int mid = (high + low) / 2;
		while (high - low > 1) {
			if (A[mid] > target) {
				high = mid;
				mid = (low + high) / 2;
			} else if (A[mid] < target) {
				low = mid;
				mid = (low + high) / 2;
			} else {
				int i = mid;
				while (i + 1 < size && A[i + 1] == target) {
					i++;
				}
				int j = mid;
				while (j - 1 >= 0 && A[j - 1] == target) {
					j--;
				}
				int[] result = { j, i };
				return result;
			}
		}
		if (A[high] == target) {
			int i = high;
			while (i + 1 < size && A[i + 1] == target) {
				i++;
			}
			int j = high;
			while (j - 1 >= 0 && A[j - 1] == target) {
				j--;
			}
			int[] result = { j, i };
			return result;
		} else if(A[low] == target) {
			int i = low;
			while (i + 1 < size && A[i + 1] == target) {
				i++;
			}
			int j = low;
			while (j - 1 >= 0 && A[j - 1] == target) {
				j--;
			}
			int[] result = { j, i };
			return result;
		}
		
		int[] result = { -1, -1 };
		return result;
	}
}
