package array;

public class FindAPeakElement {

	public static void main(String[] args) {
		int[] num = {3,4,3,2,1};
		System.out.println(findPeakElement(num));
	}
    public static int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
        	return -1;
        }
        if (num.length == 1) {
        	return 0;
        }
        if (num.length == 2) {
        	if (num[0] > num[1]) {
        		return 0;
        	} else {
        		return 1;
        	}
        }
        
        int low = 0;
        int high = num.length - 1;
        int mid = (low + high)/2;
        while (high - low > 2) {
        	if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
        		return mid;
        	} else if (num[mid] < num[mid - 1]) {
        		high = mid;
        		mid = (low + high)/2;
        	} else {
        		low = mid;
        		mid = (low + high)/2;
        	}
        	mid = (low + high)/2;
        }
        
        if (num[low] > num[low + 1]) {
        	return low;
        } else if (num[high] > num[high - 1]) {
        	return high;
        } else {
        	return low + 1;
        }
    }
}
