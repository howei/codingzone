package array;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] num = { -2, -3, -3, 10, 7, 0, 9, -4, 6, -1, 5 };
		int target = 26;
		int result = threeSumClosest(num, target);
		System.out.println(result);
	}

	public static int threeSumClosest(int[] num, int target) {
		int sum = num[0] + num[1] + num[2];
		int minDist = Math.abs(sum - target);
		int closestSum = sum;

		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int low = i + 1;
			int high = num.length - 1;
			
			while (high - low >= 1) {
				sum = num[i] + num[low] + num[high];
				if (Math.abs(sum - target) < minDist) {
					minDist = Math.abs(sum - target);
					closestSum = sum;
				}
				if (Math.abs(num[i] + num[low + 1] + num[high] - target) < Math
						.abs(num[i] + num[low] + num[high - 1] - target)) {
					low++;
				} else {
					high--;
				}
			}
		}

		return closestSum;
	}
}
