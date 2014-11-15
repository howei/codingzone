package array;

import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] A = { 100, 4, 200, 0, 1, 3, 2 };
		System.out.println(longestConsecutive(A));
	}

	public static int longestConsecutive(int[] num) {
		int size = num.length;
		if (size == 0) {
			return 0;
		}

		HashSet<Integer> set = new HashSet<Integer>();
		int maxL = 0;
		for (int e : num) {
			set.add(e);
		}

		for (int i = 0; i < size; i++) {
			int len = 1;
			int v = num[i];
			while (set.contains(v - 1)) {
				set.remove(v - 1);
				len++;
				v--;
			}
			v = num[i];
			while (set.contains(v + 1)) {
				set.remove(v + 1);
				len++;
				v++;
			}
			maxL = Math.max(maxL, len);
		}
		return maxL;
	}
}
