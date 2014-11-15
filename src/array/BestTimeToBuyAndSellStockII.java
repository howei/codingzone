package array;

public class BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		int[] prices = { 2, 3, 10, 7, 0, 9, 4, 6 };
		System.out.println(maxProfit(prices));
	}
    public static int maxProfit(int[] prices) {
        int size = prices.length;
        int profit = 0;
        for (int i = 1; i < size; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
