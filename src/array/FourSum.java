package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		int[] num = { 1,0,-1,0,-2,2 };
		// int[] num = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int target = 0;
		List<List<Integer>> result = fourSum(num, target);
		System.out.println(result.toString());
	}

	public static List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int size = num.length;
		if (size < 4) {
			return result;
		}

		Arrays.sort(num);
		for (int i = 0; i < size - 3; i++) {
			while (i > 0 && num[i] == num[i - 1]) {
				i++;
				if (i >= size - 3) {
					return result;
				}
			}
			for (int j = i + 1; j < size - 2; j++) {
				while (j > i + 1 && num[j] == num[j - 1]) {
					j++;
					if (j >= size - 2) {
						break;
					}
				}
				int low = j + 1;
				int high = size - 1;

				while (high - low >= 1) {

					if (num[i] + num[j] + num[low] + num[high] == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[low]);
						list.add(num[high]);
						result.add(list);
						while (high - low > 1 && num[high] == num[high - 1]) {
							high--;
						}
						high--;
						while (high - low > 1 && num[low] == num[low + 1]) {
							low++;
						}
						low++;
					} else if (num[i] + num[j] + num[low] + num[high] > target) {
						high--;
					} else {
						low++;
					}
				}
				System.out.println(i + ", " + j + ", " + low + ", " + high);
			}
		}

		return result;
	}
}
