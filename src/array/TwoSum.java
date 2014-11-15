package array;

import java.util.HashMap;
import java.util.Map;

/**
 * another version is the numbers are sorted. how to do it without hashmap?
 * use from low = 0, high = size - 1. O(n)
 * @author howei
 * 
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] numbers = { 2, 3, 10, 7, 0, 9, 4, 6 };
		int target = 8;
		int[] result = twoSum(numbers, target);
		System.out.println(result[0] + ", " + result[1]);
	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		int size = numbers.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < size; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[0] = i < map.get(target - numbers[i]) ? i + 1 : map
						.get(target - numbers[i]) + 1;
				result[1] = i > map.get(target - numbers[i]) ? i + 1 : map
						.get(target - numbers[i]) + 1;
				return result;
			} else {
				map.put(numbers[i], i);
			}
		}

		return result;
	}
}
