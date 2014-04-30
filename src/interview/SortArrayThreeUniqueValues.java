package interview;

/**Given an array contains integers with values either be 1, 2, or 3.
*write a function to sort this array. Expected complexity O(n).
@author howei
*
*/

public class SortArrayThreeUniqueValues {

	static int[] sortArray(int[] array) {
		int size = array.length;
		int frontInt = 0;
		int backInt = size - 1;
		for (int i = 0; i < backInt; i++) {
			if (array[i] == 1) {
				array = swap(frontInt,i, array);
				frontInt++;
			} 
			if (array[i] == 3) {
				array = swap(backInt, i, array);
				backInt--;
			}
		}
		return array;
	}
	
	static int[] swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
	
	static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,1,2,1,1,3,2,2,1};
		System.out.print("Original array: ");
		print(arr);
		arr = sortArray(arr);
		System.out.print("  Sorted array: ");
		print(arr);
		
	}
}

	