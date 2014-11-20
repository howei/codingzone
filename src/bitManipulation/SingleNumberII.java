package bitManipulation;

public class SingleNumberII {

	public static void main(String[] args) {
		int A[] = { 1,1,3,1,3,499889,5,6,3,6,5,5,6};
		System.out.println(singleNumber(A));
	}
    public static int singleNumber(int[] A) {
    	int num = 0;
        for (int i = 0; i < 32; i++) {
        	int ithBit = 0;
        	for (int j = 0; j < A.length; j++) {
        		int tmp = A[j];
        		tmp = tmp >> (31 - i);
        		ithBit += tmp & 0x1;
        	}
        	ithBit = ithBit % 3;
        	int k = 0;
        	k = k | ithBit;
        	k = k << (31 - i);
        	num = num | k;
        }
        return num;
    }
}
