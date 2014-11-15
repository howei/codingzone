package array;

public class RotateImage {

	public static void main(String[] args) {
		int n = 4;
		int[][] image = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				image[i][j] = i + j;
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(image[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("rotated:");
		int[][] rotated = rotate(image);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(rotated[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static int[][] rotate(int[][] matrix) {
		int n = matrix.length;

		for(int i = 0; i < n/2; i++) {
			for(int j = i; j < n - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = tmp;
			}
		}
		return matrix;
	}
}
