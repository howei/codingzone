package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		System.out.println(grayCode(3));

	}
    public static List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
        	res.add(0);
        	return res;
        }

        List<Integer> prev = grayCode(n - 1);
        res.addAll(prev);
        for (int i = prev.size() - 1; i >= 0; i--) {
        	res.add((1<<(n - 1)) + prev.get(i));
        }
        return res;
    }
}
