package array;

public class UniquePathsII {

	public static void main(String[] args) {
		int[][] matrix = {
				{0,0,0,0,0},
				{0,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,0,0}
		};
		System.out.println(uniquePathsWithObstacles(matrix));
	}
	
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        obstacleGrid[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < cols; j++) {
    			if(i == 0 && j > 0) {
    				if (obstacleGrid[i][j] == 0) {
    					obstacleGrid[i][j] = obstacleGrid[i][j - 1];
    				} else {
    					obstacleGrid[i][j] = 0;
    				}
    			} else if (i > 0 && j == 0) {
    				if (obstacleGrid[i][j] == 0) {
    					obstacleGrid[i][j] = obstacleGrid[i - 1][j];
    				} else {
    					obstacleGrid[i][j] = 0;
    				}
    			} else if (i > 0 && j > 0) {
    				if (obstacleGrid[i][j] == 0) {
    					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
    				} else {
    					obstacleGrid[i][j] = 0;
    				}
    			}
    		}
    	}
    return obstacleGrid[rows - 1][cols - 1];	
    }
	
}
