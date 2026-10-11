class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int areaMax = 0;

        while (left < right) {
            areaMax = Math.max(areaMax, Math.min(heights[left], heights[right]) * (right - left));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return areaMax;
    }
}
