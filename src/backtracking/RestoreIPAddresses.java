package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("0005"));
	}

	public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
        	return res;
        }
        return add(s, 0, 1);
    }

	public static List<String> add(String s, int start, int level) {
		List<String> res = new ArrayList<String>();
		int size = s.length();
		int end = Math.min(size, start + 3);
		for (int i = start; i < end; i++) {
			if (((Integer.valueOf(s.substring(start, start + 1)) == 0 && start == i) ||
					Integer.valueOf(s.substring(start, start + 1)) != 0)
					&& Integer.valueOf(s.substring(start, i + 1)) <= 255) {
				if (i + 1 < size) {
					List<String> list = add(s, i + 1, level + 1);
					for (String str : list) {
						String tmp = s.substring(start, i + 1) + "." + str;
						res.add(tmp);
					}
				} else {
					if (level == 4) {
						res.add(s.substring(start, i + 1));
					}
				}
			}
		}
		return res;
	}
}
