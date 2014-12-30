package math;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
        	num = num * 26 + s.charAt(i) - 'A' + 1;
        }
        return num;
    }
}
