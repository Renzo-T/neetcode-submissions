class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] min cost to get to step
        // dp[i] = Math.min(dp[i-2] cost[i-2], dp[i-1], cost[i-1])
        // since at most look back is 2 we just need three variables

        int step2 = 0; 
        int step1 = 0;
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            int step0 = Math.min(step2 + cost[i-2], step1 + cost[i-1]);
            step2 = step1;
            step1 = step0;
        }

        return Math.min(step2 + cost[n-2], step1 + cost[n-1]);
    }
}
