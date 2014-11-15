package array;

public class SetMatrixZeros {

	public static void main(String[] args) {
		int[][] matrix = {
				{0, 2, 3, 1},
				{1, 3, 0, 9},
				{1, 2, 3, 0},
		};
		
		int[][] m = setZeroes(matrix);
        int rows = matrix.length;
        int cols = matrix[0].length;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}

	}
	
    public static int[][] setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean setRow = false;
        boolean setCol = false;
        for (int i = 0; i < cols; i++) {
        	if (matrix[0][i] == 0) {
        		setRow = true;
        		break;
        	}
        }
    	
    	for (int i = 0; i < rows; i++) {
    		if (matrix[i][0] == 0) {
    			setCol = true;
    			break;
    		}
    	}
    	
    	//use first row and column to store information about zeroes
    	if (rows > 1 && cols > 1) {
    		for(int i = 1; i < rows; i++) {
    			for(int j = 1; j < cols; j++) {
    				if (matrix[i][j] == 0) {
        				matrix[i][0] = 0;
        				matrix[0][j] = 0;
    				}
    			}
    		}
    	}
    	
    	int i = 1;
    	while (rows > 1 && i < rows) {
    		if (matrix[i][0] == 0) {
    			for (int k = 1; k < cols; k++) {
    				matrix[i][k] = 0;
    			}
    		}
    		i++;
    	}
    	int j = 1;
    	while (cols > 1 && j < cols) {
    		if (matrix[0][j] == 0) {
    			for (int k = 1; k < rows; k++) {
    				matrix[k][j] = 0;
    			}
    		}
    		j++;
    	}    	
    	
    	//set first row and first column
    	if(setRow) {
    		for (int k = 0; k < cols; k++) {
    			matrix[0][k] = 0;
    		}
    	}
    	
    	if(setCol) {
    		for (int k = 0; k < rows; k++) {
    			matrix[k][0] = 0;
    		}
    	}
    	
    	return matrix;
    }
}
