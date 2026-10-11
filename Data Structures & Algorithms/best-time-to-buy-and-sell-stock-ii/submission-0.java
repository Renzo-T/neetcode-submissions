class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int prevPrice = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] >= prevPrice) {
                profit += prices[i] - prevPrice;
            }
            prevPrice = prices[i];
        }

        return profit;
        // always sell buy
        // if price lowers sell at prev buy at current
        // if price increases sell buy
    }
}