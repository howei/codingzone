package string;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String s = " y";
		System.out.println(lengthOfLastWord(s));
	}
	
    public static int lengthOfLastWord(String s) {
    	//can s.trim() be used?
    	
        int len = s.length();
        if (len == 0) {
        	return 0;
        }
        
        int i = len - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
        	i--;
        }
        
        int lenLast = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
        	lenLast++;
        	i--;
        }
        return lenLast;
    }
}
