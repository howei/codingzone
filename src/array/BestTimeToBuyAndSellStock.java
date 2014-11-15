package array;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = { 2, 3, 10, 7, 0, 9, 4, 6, 10 };
		System.out.println(maxProfit(prices));
	}
	
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i : prices) {
        	if (i < min) {
        		min = i;
        	}
        	if (i - min > profit) {
        		profit = i - min;
        	}
        }
        
        return profit;
    }
}
