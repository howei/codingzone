package array;

import java.util.Random;

public class DutchNationalFlagProblem {

	public static void main(String[] args) {
		int A[] = new int[10];
		int size = A.length;
		for(int i = 0; i < size; i++) {
			Random rand = new Random();
			A[i] = rand.nextInt(3);
			System.out.print(A[i] + ", ");
		}
		System.out.println();
		int B[] = sortColors(A);
		for(int i = 0; i < size; i++) {
			System.out.print(B[i] + ", ");
		}
        System.out.println();
	}
	
    public static int[] sortColors(int[] A) {
    	int size = A.length;
        if(size == 0 || size == 1) {
        	return A;
        }
        int left = 0;
        for(int i=0; i< size; i++) {
        	if(A[i] != 0) {
        		left = i;
        		break;
        	}
        }
        int right = size - 1;
        for(int i=size - 1; i > 0; i--) {
        	if(A[i] != 2) {
        		right = i;
        		break;
        	}
        }
        System.out.println("left= " + left + ", right= " + right);
        int i = left;
        while (i <= right && left < right & i >= left) {
        	if (A[i] == 0) {
        		int tmp = A[i];
        		A[i] = A[left];
        		A[left] = tmp;
        		left++;
                for(int j=left; j<= right; j++) {
                	if(A[j] != 0) {
                		left = j;
                		i = j;
                		break;
                	}
                }
        	} else if (A[i] == 2) {
        		int tmp = A[i];
        		A[i] = A[right];
        		A[right] = tmp;
        		right--;
                for(int j=right; j >= left; j--) {
                	if(A[j] != 2) {
                		right = j;
                		break;
                	}
                }
        	} else {
        		i++;
        	}
        }
        System.out.println("left= " + left + ", right= " + right + ", i= " + i);
        return A;
    }

}
