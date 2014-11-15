package array;

import java.util.ArrayList;
import java.util.List;

public class KthRowInPascalTriangle {

	public static void main(String[] args) {
		System.out.println(getRow(3));
	}
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        List<Integer> tmpRow = new ArrayList<Integer>(row);
        if (rowIndex == 0) {
        	return row;
        }
        for(int i = 1; i < rowIndex + 1; i++) {
        	int j = 1;
        	while(i > 1 && j < i) {
        		row.set(j, tmpRow.get(j - 1) + tmpRow.get(j));
        		j++;
        	}
        	row.add(1);
        	tmpRow = new ArrayList<Integer>(row);
        }
        return row;
    }
}
