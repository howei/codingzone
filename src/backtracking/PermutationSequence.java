package backtracking;

import java.util.ArrayList;

import java.util.List;




public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(getPermutationR(4, 6));
    }

    //iterative method
    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        if (k > fact(n)) {
            return "";
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int digit = 0;
        k -= 1;
        while (n >= 1) {
            int factN = fact(n - 1);
            int pos = k/factN;
            digit = list.get(pos);
            list.remove(pos);
            res.add(digit);
            k -= factN * pos;
            n--;
        }
        String result = "";
        for (Integer item : res) {
        	result += item;
        }
        return result;
    }

    //recursive method
    public static String getPermutationR(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        if (k > fact(n)) {
            return "";
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        k -= 1;
        res = p(n, k, list);
        String result = "";
        for (Integer item : res) {
        	result += item;
        }
        return result;
    }

    public static List<Integer> p(int n, int k, List<Integer> list) {
        List<Integer> res = new ArrayList<Integer>();
        if (n == 1) {
            res.add(list.get(k));
            list.remove(list.get(k));
        } else {
            int factN = fact(n - 1);
            int pos = k/factN;
            int digit = list.get(pos);
            list.remove(pos);
            res.add(digit);
            res.addAll(p(n - 1, k - factN * pos, list));
        }
        return res;
    }

    public static int fact(int n) {
        int f = 1;
        if (n == 0) {
            return f;
        } else {
            return fact(n - 1) * n;
        }
    }

}