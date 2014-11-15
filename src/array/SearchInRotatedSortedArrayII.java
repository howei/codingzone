package array;

public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		int[] num = {2,2,2,2,2,2,2,3,4,1,2};
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + ", ");
		}
		System.out.println();
		int x = 5;
		System.out.println(x + " found? " + findValue(num, x));
	}

	public static boolean findValue(int[] A, int target) {
		if (A.length == 0) {
			return false;
		}
		int left = 0;
		int right = A.length - 1;
		int mid = (left + right) / 2;
		if (A[mid] == target) {
			return true;
		}
		while (right - left > 1) {
			if (A[mid] > A[left]) {
				if (target > A[mid] || target < A[left]) {
					left = mid;
				} else {
					right = mid;
				}
			} else if (A[mid] < A[left]) {
				if (target < A[mid] || target > A[right]) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
        		int i = right;
        		while (i >= left && i >= 1 && A[i - 1] == A[right]) {
        			i -= 1;
        		}
        		right = i;
        		
        		int j = left;
        		while (j < right && j + 1 < A.length && A[j + 1] == A[left]) {
        			j += 1;
        		}
        		left = j;
        		
        		if(right - left > 1) {
        			left += 1;
        		}
			}
			mid = (left + right) / 2;
			if (A[mid] == target) {
				return true;
			}
		}
		if (A[right] == target) {
			return true;
		} else {
			return false;
		}
	}
}
