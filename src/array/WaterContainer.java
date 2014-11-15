package array;

public class WaterContainer {

	public static void main(String[] args) {
		int[] height = {1, 4, 0, 2, 5, 4, 2, 0, 2};
        System.out.println("max area is: " + maxArea(height));
	}

	public static int maxArea(int[] height) {
		int size = height.length;
		if (size < 2) {
			return 0;
		}
		int low = 0;
		int high = size - 1;
		int maxArea = 0;
		while (high - low > 0) {
			maxArea = Math.max(maxArea, Math.min(height[low], height[high]) * (high - low));
			if(height[low] < height[high]) {
				low++;
			} else {
				high--;
			}
		}	
		return maxArea;
	}
}
