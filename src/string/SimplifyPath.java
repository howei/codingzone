package string;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		String s = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
		System.out.println(simplifyPath(s));

	}
    public static String simplifyPath(String path) {
    	if (path == null || path.length() == 0) {
    		return "";
    	}
    	if (path.equals("/")) {
    		return path;
    	}
    	int len = path.length();
    	if (path.charAt(len - 1) == '/') {
    		path = path.substring(0, len - 1);
    	}
    	
    	String[] array = path.split("/");
    	int aLen = array.length;
    	Stack<String> stack = new Stack<String>();
    	for (int i = 1; i < aLen; i++) {
    		if ( !"..".equals(array[i]) &&  !".".equals(array[i]) && !"".equals(array[i])) {
    			stack.push(array[i]);
    		} else if ("..".equals(array[i])) {
    			if (!stack.empty()) {
    				stack.pop();
    			}
    		}
    	}
    	String result = "";
    	while (!stack.empty()) {
    		result = "/" + stack.peek() + result;
    		stack.pop();
    	}
    	if ("".equals(result)) {
    		return "/";
    	}
    	return result;
    }
}
