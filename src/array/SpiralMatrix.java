package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		System.out.println(spiralOrder(matrix).toString());
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		int rows = matrix.length;
		List<Integer> list = new ArrayList<Integer>();
        if(rows == 0) {
            return list;
        }
        int cols = matrix[0].length;
        
		int rowsStart = 0;
		int colsStart = 0;
		int rowsEnd = rows - 1;
		int colsEnd = cols - 1;
		while (rowsEnd >= rowsStart && colsEnd >= colsStart) {
			for (int i = colsStart; i <= colsEnd; i++) {
				list.add(matrix[rowsStart][i]);
			}
			rowsStart++;

			if (rowsEnd >= rowsStart && colsEnd >= colsStart) {
				for (int i = rowsStart; i <= rowsEnd; i++) {
					list.add(matrix[i][colsEnd]);
				}
				colsEnd--;
			}

			if (rowsEnd >= rowsStart && colsEnd >= colsStart) {
				for (int i = colsEnd; i >= colsStart; i--) {
					list.add(matrix[rowsEnd][i]);
				}
				rowsEnd--;
			}

			if (rowsEnd >= rowsStart && colsEnd >= colsStart) {
				for (int i = rowsEnd; i >= rowsStart; i--) {
					list.add(matrix[i][colsStart]);
				}
				colsStart++;
			}
		}

		return list;
	}
}
