package array;

public class BestTimeToBuyAndSellStockIII {
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
   Design an algorithm to find the maximum profit. You may complete at most two transactions.

   Note:
   You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
	public static void main(String[] args) {
		int[] prices = { 0, 3, 10, 7, 0, 9, 4, 6, 10 };
		System.out.println(maxProfit(prices));
	}
	
    public static int maxProfit(int[] prices) {
    	int size = prices.length;
    	int mProfit = 0;
    	int[] maxProf = new int[size];
    	int lowest = Integer.MAX_VALUE;
    	for (int i = 0; i < size; i++) {
    		lowest = Math.min(lowest, prices[i]);
    		if (i > 0) {
    			maxProf[i] = Math.max(prices[i] - lowest, maxProf[i -1]);
    		} else {
    			maxProf[i] = 0;
    		}
    	}
		
		int highest = Integer.MIN_VALUE;
    	for (int i = size - 1; i >= 0; i--) {
    		highest = Math.max(highest, prices[i]);
    		mProfit = Math.max(mProfit, maxProf[i] + highest - prices[i]);
    	}
    	return mProfit;
    }
    
}
