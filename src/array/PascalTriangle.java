package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		System.out.println(generate(3).toString());
	}
	
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<List<Integer>>();
        if(numRows <= 0) {
            return tri;
        }
        List<Integer> line = new ArrayList<Integer>();
        line.add(1);
        tri.add(new ArrayList<Integer>(line));
        if(numRows == 1) {
            return tri;
        }
        line.add(1);
        tri.add(new ArrayList<Integer>(line));
        if(numRows == 2) {
            return tri;
        } 

        for(int i = 3; i <= numRows; i++) {
            for(int j = 1; j < i - 1; j++) {
                line.set(j, tri.get(i - 2).get(j - 1) + tri.get(i - 2).get(j));
            }
            line.add(1);
            tri.add(new ArrayList<Integer>(line));
        }
        return tri;
    }

}
