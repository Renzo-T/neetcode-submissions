class Solution {
    public int majorityElement(int[] nums) {
        // boyer moore voting algorithm
        int canidate = 0;
        int ct = 0;
    
        for (int n : nums) {
            if (ct == 0) {
                canidate = n;
            }
            if (n == canidate) {
                ct++;
            } else {
                ct--;
            }
        }
        return canidate;
    }
}