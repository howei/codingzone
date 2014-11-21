package string;
/**
 * Implementation too ugly. Need to be cleaner.
 * @author hongren
 *
 */
public class ImplementStrStr {

	public static void main(String[] args) {
		System.out.println(strStr("aaaaa", "aaaa"));

	}

	public static int strStr(String haystack, String needle) {
		if (needle == null || haystack == null) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		}
		if (haystack.length() == 0 || haystack.length() < needle.length()) {
			return -1;
		}
		int size1 = haystack.length();
		int size2 = needle.length();
		int start = 0;
		while (start + size2 <= size1) {
			int count = 0;
			int newStart = start;
			boolean newStartSet = false;
			for (int i = start; i < size1 && i - start < size2; i++) {
				if (haystack.charAt(i) - needle.charAt(i - start) == 0) {
					count++;
					if (count == size2) {
						return start;
					}
				}
				if (haystack.charAt(i) - needle.charAt(0) == 0 && i != start && newStartSet == false) {
					newStart = i;
					newStartSet = true;
				}
			}
			if (newStart == start) {
				start += size2;
			} else {
				start = newStart;
			}
		}
		return -1;
	}
}
