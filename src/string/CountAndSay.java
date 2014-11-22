package string;

public class CountAndSay {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(countAndSay(i));
		}

	}
	
    public static String countAndSay(int n) {
        if (n == 1) {
        	return "1";
        } else if (n <= 0) {
        	return "";
        }
        
        String s = "";
        String preS = countAndSay(n - 1);
        int len = preS.length();
        int i = 0;
        while (i < len) {
        	int j = i;
        	char num = preS.charAt(i);
        	int count = 0;
        	while (j < len && preS.charAt(j) == preS.charAt(i)) {
        		count++;
        		j++;
        	}
        	s += String.valueOf(count) + num;
        	i = j;
        }
        return s;
    }
}
