class Solution {
    public int subsetXORSum(int[] nums) {
        // FIGURE OUT HOW MANY TIMES IT IS APPLIED, IF ODD DO ONCE IF EVEN nothing.
        //2^n its in half the subsets
        //dfs
        return dfs(nums, 0, 0);

    }

    private int dfs(int[] nums, int i, int total) {
        if (i >= nums.length) {
            return total;
        }
        return dfs(nums, i+1, total ^ nums[i]) + dfs(nums, i+1, total);
    }
}