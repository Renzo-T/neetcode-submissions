class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxElement = new PriorityQueue<>(
            (a, b) -> Integer.compare(nums[b], nums[a])
        );
        int[] res = new int[nums.length - k + 1];
        // init window
        for (int i = 0; i < k; i++) {
            maxElement.offer(i);      
        }
        res[0] = nums[maxElement.peek()];

        for (int i = 1; i < res.length; i++) {
            maxElement.offer(i + k - 1);
            while (maxElement.peek() < i) {
                maxElement.poll();
            }
            res[i] = nums[maxElement.peek()];
        }

        return res;
    }
}
