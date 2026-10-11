class Solution {
    public int majorityElement(int[] nums) {
        // brute force: sort -> pick middle element
        // hashmap keep counts, if count > 50% 
        // int[32] each bit we keep track of how often set. If set > 50% its the bit
        int canidate = nums[0];
        int ct = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == canidate) {
                ct++;
            } else {
                ct--;
                if (ct == 0) {
                    canidate = nums[i];
                    ct = 1;
                }
            }
        }

        return canidate;
    }
}