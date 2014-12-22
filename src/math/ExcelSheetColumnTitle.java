package math;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        if (n <= 0) {
        	return null;
        }
        String res = "";
        while (n > 0) {
        	int tmp = (n - 1)%26;
        	res = (char)(tmp + 'A') + res;
        	n = (n - 1)/26;
        }
        return res;
    }
}
