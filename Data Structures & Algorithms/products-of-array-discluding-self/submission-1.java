class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] productArray = new int[n];
        int rollingProduct = 1;
        for (int i = 0; i < n; i++) {
            productArray[i] = rollingProduct;
            rollingProduct *= nums[i];
        }
        rollingProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            productArray[i] *= rollingProduct;
            rollingProduct *= nums[i];
        }

        return productArray;
    }
}  
