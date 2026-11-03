class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            int mid = (r-l)/2 + l;
            if (nums[mid] < nums[(mid-1+nums.length)%nums.length]) {
                return nums[mid];
            }
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }
}
