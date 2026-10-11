class Solution {
    public int rob(int[] nums) {
        // house i:
        // rob i -> value nums[i] + nonRobmax house i-1;
        // not rob i -> max robbing or not robbing previous house
        int prevRobbed = nums[0];
        int prevNotRobbed = 0;

        for (int i = 1; i < nums.length; i++) {
            int robbed = nums[i] + prevNotRobbed;
            int notRobbed = Math.max(prevRobbed, prevNotRobbed);

            prevRobbed = robbed;
            prevNotRobbed = notRobbed;
        }

        return Math.max(prevRobbed, prevNotRobbed);
    }
}
