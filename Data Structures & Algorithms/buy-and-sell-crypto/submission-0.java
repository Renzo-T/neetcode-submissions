class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lowest = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price > lowest) {
                max = Math.max(price-lowest, max);
            } else {
                lowest = price;
            }
        }

        return max;
    }
}
