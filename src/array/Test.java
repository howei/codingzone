package array;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		//list added to list of list is by reference?
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> tempList = new ArrayList<Integer>();
		Integer i = 0;
		list.add(i);
		tempList = new ArrayList<Integer>(list);
		System.out.println(list.toString());
		System.out.println(tempList.toString());
		i = 1;
		list.add(i);
		System.out.println(list.toString());
		System.out.println(tempList.toString());
		
		int i2 = 0;
		int j2 = 0;
		while(i2 < 3) {
			while(j2 < 3) {
				System.out.println("i, j= " + i2 + ", " + j2);
				j2++;
			}
			j2 = 0;
			i2++;
		}
		
	}

}
