package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		int[] S = {2, 2, 2, 2};
		System.out.println(subsets(S).toString());
	}

	public static List<List<Integer>> subsets(int[] S) {
		int size = S.length;
		List<List<Integer>> lList = subset(S, size);
		Iterator<List<Integer>> it = lList.iterator(); 
		int i = 0;
		while(it.hasNext()) {
			List<Integer> tmp = new ArrayList<Integer>(it.next());
			Collections.sort(tmp);
			lList.set(i, tmp);
			i++;
		}
		return lList;
	}
	
	private static List<List<Integer>>subset(int[] S, int n) {
		List<List<Integer>> lList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		lList.add(list);
		if (n == 0) {
			return lList;
		}
		
		lList.clear();
		int dup = 0;
		if (n > 1) {
			for (int i = 0; i < n; i++) {
				if (S[n - 1] == S[i]) {
					dup++;
				}
			}
		}
		List<List<Integer>> prevLList = subset(S, n - 1);
		lList.addAll(prevLList);
		Iterator<List<Integer>> it = prevLList.iterator(); 
		while(it.hasNext()) {
			List<Integer> tmp = new ArrayList<Integer>(it.next());
            int contains = 0;
            Iterator<Integer> it2 = tmp.iterator();
            while(it2.hasNext()) {
            	if (it2.next() == S[n - 1]) {
            		contains++;
            	}
            }
			if (dup == 0 || (dup - contains == 1)) {
				tmp.add(S[n - 1]);
				lList.add(tmp);
			}
		}
		
		return lList;
	}
	
}
