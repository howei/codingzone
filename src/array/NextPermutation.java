package array;

public class NextPermutation {

	public static void main(String[] args) {
		int[] num = { 1, 2, 1 };
		nextPermutation(num);
		for (int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void nextPermutation(int[] num) {
		int size = num.length;
		int i = size - 1;
		for (; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				int j = size - 1;
				while (num[j] <= num[i - 1]) {
					j--;
				}
				int tmp = num[j];
				num[j] = num[i - 1];
				num[i - 1] = tmp;

				int left = i;
				int right = size - 1;
				while (left < right) {
					tmp = num[left];
					num[left] = num[right];
					num[right] = tmp;
					left++;
					right--;
				}
				return;
			}
		}

		int left = i;
		int right = size - 1;
		while (left < right) {
			int tmp = num[left];
			num[left] = num[right];
			num[right] = tmp;
			left++;
			right--;
		}
		return;
	}
}
