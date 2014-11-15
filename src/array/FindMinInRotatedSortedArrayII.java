package array;

public class FindMinInRotatedSortedArrayII {

	public static void main(String[] args) {
		int[] num = {2,2,2,2,1,2};
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + ", ");
		}
		System.out.println();
		System.out.println("minimum is: " + findMin(num));
	}
	
    public static int findMin(int[] num) {
        int left = 0;
        int right = num.length - 1;
        int mid = (left + right)/2;
        while(right - left > 1) {
        	if(num[mid] > num[0]) {
        		left = mid;
        	} else if (num[mid] < num[0]) {
        		right = mid;
        	} else {
        		int i = right;
        		while (i >= left && i >= 1 && num[i - 1] == num[right]) {
        			i -= 1;
        		}
        		right = i;
        		
        		int j = left;
        		while (j < right && j + 1 < num.length && num[j + 1] == num[left]) {
        			j += 1;
        		}
        		left = j;
        		
        		if(right - left > 1) {
        			left += 1;
        		}
        	}
        	mid = (left + right)/2;
        }
        
    	return Math.min(Math.min(num[left], num[right]), num[0]);
    }
}
