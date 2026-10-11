class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target-nums[i]);
            if (idx != null) {
                return new int[]{idx, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }
}
