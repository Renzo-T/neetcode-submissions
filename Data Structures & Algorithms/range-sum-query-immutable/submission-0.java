class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        //-2,0,3,-5,2,-1
        //-2,-2,1,-4,-2,-3
    }
    
    public int sumRange(int left, int right) {
        return sums[right+1] - sums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */