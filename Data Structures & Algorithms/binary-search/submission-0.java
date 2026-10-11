class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (r - l)/2 + l;
            int mid = nums[m];
            if (mid == target) {
                return m;
            } else if (mid > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
