class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int biggestTradeProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            int profit = prices[i] - minPrice;
            biggestTradeProfit = Math.max(biggestTradeProfit, profit);
        }

        return biggestTradeProfit;
    }
}
