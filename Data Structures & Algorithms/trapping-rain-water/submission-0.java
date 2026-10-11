class Solution {
    public int trap(int[] height) {
        // heighest to the left of i and heighest to the right of i  -> min - height[i] = water at i
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for (int i = 1; i < n; i++) {
            int j = n-1-i;
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }

        int trappedWater = 0;

        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return trappedWater;
    }   
}
