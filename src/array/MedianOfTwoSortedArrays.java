package array;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] B = {4,5,6};
        System.out.println(median(A, B));
    }

    public static double median(int[] A, int[] B) {
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return 0;
        }
        
        if (A == null || A.length == 0) {
            return med(B, 0, B.length - 1);
        } else if (B == null || B.length == 0) {
            return med(A, 0, A.length - 1);
        } else if (B.length == 1 && A.length == 1) {
            return (A[0] + B[0])/2.0;
        } else if (A.length == 1 && B.length == 2) {
            if(A[0] >= (B[0] + B[1])/2.0) {
                return Math.min(A[0], B[1]);
            } else {
                return Math.max(A[0], B[0]);
            }
        } else if (B.length == 1 && A.length == 2) {
            if(B[0] >= (A[0] + A[1])/2.0) {
                return Math.min(B[0], A[1]);
            } else {
                return Math.max(B[0], A[0]);
            }
        }
        
        int lowA = 0;
        int lowB = 0;
        int highA = A.length - 1;
        int highB = B.length - 1;
        
        while (highA - lowA > 1 && highB - lowB > 1) {
            double medA = med(A, lowA, highA);
            double medB = med(B, lowB, highB);
            if (medA == medB) {
                return medA;
            }
            int move = Math.min((highA - lowA)/2, (highB - lowB)/2);
            move = Math.max(1, move);
            if (medA > medB) {
                highA -= move;
                lowB += move;
            } else {
                highB -= move;
                lowA += move;
            }
            System.out.println(lowA + ", " + highA + ", " + lowB + ", " + highB);
        }
        
        int diffA = highA - lowA;
        int diffB = highB - lowB;
        if (diffA == 0 && diffB == 0) {
            return (A[lowA] + B[lowB])/2.0;
        } else if (diffA == 0) {
            return medWOne(A[lowA], B, lowB, highB);
        } else if (diffB == 0) {
            return medWOne(B[lowB], A, lowA, highA);
        }  else if (diffA == 1) {
            return medWTwo(A[lowA], A[highA], B, lowB, highB);
        } else if (diffB == 1) {
            return medWTwo(B[lowB], B[highB], A, lowA, highA);
        } 
        
        return 0;
        
    }
    
    public static double med(int[] A, int start, int end) {
        if (start == end) {
            return A[start];
        }
        //odd number of numbers. right, not even number 
        if ((end - start) % 2 == 0) {
            return A[(end + start)/2];
        } else {
            return (A[(end + start)/2] + A[(end + start)/2 + 1])/2.0;
        }
    }
    
    public static double medWOne(int num, int[] A, int start, int end) {
        if (end == start) {
            return (num + A[start])/2.0;
        }
        if ((end - start)%2 == 0) {
            if (num <= A[(start + end)/2 - 1]) {
                return (A[(start + end)/2 - 1] + A[(start + end)/2])/2.0;
            } else if (num >= A[(start + end)/2 + 1]) {
                return (A[(start + end)/2] + A[(start + end)/2 + 1])/2.0;
            } else {
                return (A[(start + end)/2] + num)/2.0;
            }
        } else {
            if (num <= A[(start + end - 1)/2]) {
                return A[(start + end - 1)/2];
            } else if (num >= A[(start + end + 1)/2]) {
                return A[(start + end + 1)/2];
            } else {
                return num;
            }
        }
    }
    
    public static double medWTwo(int numLow, int numHigh, int[] A, int start, int end) {
        if (end - start == 1) {
            return (Math.max(numLow, A[start]) + Math.min(numHigh, A[end]))/2.0;
        }

        if ((end - start)%2 == 0) {
            int[] tmp = new int[5];
            tmp[0] = numLow;
            tmp[1] = numHigh;
            tmp[2] = A[(start + end)/2];
            tmp[3] = A[(start + end)/2 - 1];
            tmp[4] = A[(start + end)/2 + 1];
            Arrays.sort(tmp);
            return tmp[2];
        } else {
            int[] tmp = new int[6];
            tmp[0] = numLow;
            tmp[1] = numHigh;
            tmp[2] = A[(start + end - 1)/2 - 1];
            tmp[3] = A[(start + end - 1)/2];
            tmp[4] = A[(start + end + 1)/2];
            tmp[5] = A[(start + end + 1)/2 + 1];
            Arrays.sort(tmp);
            return (tmp[2] + tmp[3])/2.0;
        }
    }
}
