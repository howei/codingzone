package math;

public class AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("0", "0"));

	}
    public static String addBinary(String a, String b) {
        int carry = 0;
        int sizeA = a.length();
        int sizeB = b.length();
        if (sizeA < sizeB) {
        	int i = 0;
        	while (i < sizeB - sizeA) {
        		a = "0" + a;
        		i++;
        	}
        }
        if (sizeB < sizeA) {
        	int i = 0;
        	while (i < sizeA - sizeB) {
        		b = "0" + b;
        		i++;
        	}
        }

        int maxLen = Math.max(sizeA, sizeB);
        String sum = "";
        for (int i = maxLen - 1; i >= 0; i--) {
        	int add = (carry + (Integer.parseInt(a.substring(i, i + 1)) + Integer.parseInt(b.substring(i, i + 1))));
        	sum = String.valueOf(add % 2) + sum;
        	carry = add/2;
        }
        if (carry > 0) {
        	sum = "1" + sum;
        }
        return sum;
    }
}
