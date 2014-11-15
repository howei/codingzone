package array;

public class SpiralMatrixII {

	public static void main(String[] args) {
		int[][] m = generateMatrix(4);
		int size = m.length;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
    public static int[][] generateMatrix(int n) {
    	//how about n == 0?
        int[][] m = new int[n][n];
        
		int rowsStart = 0;
		int colsStart = 0;
		int rowsEnd = n - 1;
		int colsEnd = n - 1;
		int counter = 1;
		while (rowsEnd >= rowsStart && colsEnd >= colsStart) {
			for (int i = colsStart; i <= colsEnd; i++) {
				m[rowsStart][i] = counter;
				counter++;
			}
			rowsStart++;

			if (rowsEnd >= rowsStart && colsEnd >= colsStart) {
				for (int i = rowsStart; i <= rowsEnd; i++) {
					m[i][colsEnd] = counter;
					counter++;
				}
				colsEnd--;
			}

			if (rowsEnd >= rowsStart && colsEnd >= colsStart) {
				for (int i = colsEnd; i >= colsStart; i--) {
					m[rowsEnd][i] = counter;
					counter++;
				}
				rowsEnd--;
			}

			if (rowsEnd >= rowsStart && colsEnd >= colsStart) {
				for (int i = rowsEnd; i >= rowsStart; i--) {
					m[i][colsStart] = counter;
					counter++;
				}
				colsStart++;
			}
		}
        
        
        return m;
    }
}
