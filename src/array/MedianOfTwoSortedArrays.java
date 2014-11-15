package array;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] A = {1, 3, 6, 19, 34, 100, 200};
		int[] B = {2, 3, 4, 6, 9, 14, 50, 100, 150};
		System.out.println(findMedianSortedArrays(A, B));
	}
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        double medianA = 0;
        double medianB = 0;
        int leftA = 0;
        int rightA = m - 1;
        int leftB = 0;
        int rightB = n - 1;
        
        if (m != 0) {
        	if (m % 2 == 0) {
        		medianA = A[m/2 - 1] + A[m/2];
        	} else {
        		medianA = A[m/2];
        	}
        }
        if (n != 0) {
        	if (n % 2 == 0) {
        		medianB = A[n/2 - 1] + A[n/2];
        	} else {
        		medianB = A[n/2];
        	}
        }
        
        if (m == 0) {
        	return medianB;
        } else if (n == 0 || medianA == medianB) {
        	return medianA;
        } else if (m == 1 && n == 1) {
        	return (medianA + medianB)/2;
        }
        
        //too tedious.....
        while (rightA - leftA > 1 && rightB - leftB > 1) {
    		int delEntries = Math.min((m - 1)/2, (n - 1)/2);
        	if (medianA > medianB) {
        		rightA -= delEntries;
        		leftB += delEntries;
        	} else if (medianA < medianB) {
        		rightB -= delEntries;
        		leftA += delEntries;
        	} else {
        		return medianA;
        	}
        }
        
        
    }
}
