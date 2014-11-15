package array;

public class SearchInA2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 5, 7},
				          {10, 11, 16, 20},
				          {23, 30, 34, 50} 
		                 };
		
        System.out.println(searchMatrix(matrix, 50));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        
        int head = 0;
        int tail = m - 1;
        int mid = (head + tail)/2;
        while (tail - head > 1) {
          if(target > matrix[mid][0]) {
            head = mid;
            mid = (head + tail)/2;
          } else if(target < matrix[mid][0]) {
            tail = mid;
            mid = (head + tail)/2;
          } else {
              return true;
          }
        }

        int row;
        if(target > matrix[tail][0]) {
        	row = tail;
        } else if (target < matrix[tail][0]) {
        	row = mid;
        } else {
        	return true;
        }
        System.out.println("row is: " + row);
        head = 0;
        tail = n - 1;
        mid = (head + tail)/2;
        while (tail - head > 1) {
          if(target > matrix[row][mid]) {
            head = mid;
            mid = (head + tail)/2;
          } else if(target < matrix[row][mid]) {
            tail = mid;
            mid = (head + tail)/2;
          } else {
              return true;
          }
        }
        if(target == matrix[row][head] || target == matrix[row][tail]) {
        	return true;
        }
        System.out.println("head: " + head + ", tail: " + tail);
        return false;
    }
}
