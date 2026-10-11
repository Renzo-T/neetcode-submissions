class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;
        
        while (left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];
            maxWater = Math.max(maxWater,
                    (right - left) * Math.min(leftHeight, rightHeight));
            if (leftHeight <= rightHeight) {
                left++;
            } 
            if (leftHeight >= rightHeight) {
                right--;
            }
        }

        return maxWater;
    }
}
