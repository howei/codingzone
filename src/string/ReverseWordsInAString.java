package string;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		String s = "L K H";
		System.out.println(reverseWords(s));
	}
	
    public static String reverseWords(String s) {
    	if (s == null) {
    		return null;
    	}
    	s = s.trim();
    	if (s.length() == 0) {
    		return s;
    	}
    	s = " " + s;
        String result = "";
        int size = s.length();
        int end = size;
        int start = end - 1;
        for (int i = size - 1; i > 0; i--) {
        	if (s.charAt(i) != ' ' && s.charAt(i - 1) != ' ') {
        		start--;
        	} else if (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ') {
        		if (start == 1) { 
        			result += s.substring(start, end);
        		} else {
        			result += s.substring(start, end) + " ";
        		}
        		start = i;
        		end = i;
        	} else {
        		end = i;
        		start = i - 1;
        	}
        }
        return result;
    }
}
