package array;

public class FindMinInRotatedSortedArray {

	public static void main(String[] args) {
		int len = 20;
		int[] num = new int[len];
		int seed = 9;
		for(int i = 0; i < len; i++) {
			num[i] = (i + seed) % len;
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
        	} else {
        		right = mid;
        	}
        	mid = (left + right)/2;
        }
        
    	return Math.min(Math.min(num[left], num[right]), num[0]);
    }
}
