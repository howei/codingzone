package math;

public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(124));

	}
    public static String intToRoman(int num) {
        String s = "";
        if (num/1000 > 0) {
        	int digit = num/1000;
        	for (int i = 0; i < digit; i++) {
        		s += "M";
        	}
        }
        num = num % 1000;
        if (num/100 > 0) {
        	int digit = num/100;
        	if(digit >= 1 && digit <=3) {
        		for (int i = 0; i < digit; i++) {
        			s += "C";
        		}
        	} else if (digit == 4) {
        		s += "CD";
        	} else if (digit == 5) {
        		s += "D";
        	} else if (digit >= 6 && digit <= 8) {
        		s += "D";
        		for (int i = 0; i < digit - 5; i++) {
        			s += "C";
        		}
        	} else {
        		s += "CM";
        	}
        }
        num = num % 100;
        if (num/10 > 0) {
        	int digit = num/10;
        	if(digit >= 1 && digit <=3) {
        		for (int i = 0; i < digit; i++) {
        			s += "X";
        		}
        	} else if (digit == 4) {
        		s += "XL";
        	} else if (digit == 5) {
        		s += "L";
        	} else if (digit >= 6 && digit <= 8) {
        		s += "L";
        		for (int i = 0; i < digit - 5; i++) {
        			s += "X";
        		}
        	} else {
        		s += "XC";
        	}
        }
        num = num % 10;
        if (num > 0) {
        	int digit = num;
        	if(digit >= 1 && digit <=3) {
        		for (int i = 0; i < digit; i++) {
        			s += "I";
        		}
        	} else if (digit == 4) {
        		s += "IV";
        	} else if (digit == 5) {
        		s += "V";
        	} else if (digit >= 6 && digit <= 8) {
        		s += "V";
        		for (int i = 0; i < digit - 5; i++) {
        			s += "I";
        		}
        	} else {
        		s += "IX";
        	}
        }
        return s;
    }
}
