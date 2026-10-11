class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxHeights = new int[n];
        int max = height[0];
        maxHeights[0] = max;
        for (int i = 1; i < n; i++) {
            max = Math.max(height[i], max);
            maxHeights[i] = max;
        }

        max = height[n-1];
        maxHeights[n-1] = max;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            maxHeights[i] = Math.min(maxHeights[i], max);
        }

        int water = 0;

        for (int i = 0; i < n; i++) {
            water += (maxHeights[i] - height[i]);
        }

        return water;
    }
}
