package array;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4},
		          {5, 6, 0, 1},
		          {3, 4, 2, 7} 
               };

        System.out.println(minPathSum(matrix));

	}
	
    public static int minPathSum(int[][] grid) {
    	int rows = grid.length;
    	int cols = grid[0].length;
    	
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (i == 0 && j > 0) {
        			grid[i][j] = grid[i][j] + grid[i][j - 1];
        		} else if (i > 0 && j == 0) {
        			grid[i][j] = grid[i][j] + grid[i - 1][j];
        		} else if (i > 0 && j > 0) {
        			grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        		}
        	}
        }
        
        
        
        return grid[rows - 1][cols - 1];
    }
}
