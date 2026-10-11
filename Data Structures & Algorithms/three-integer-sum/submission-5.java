class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> sums = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> triplets = findPair(nums, -nums[i], i);
            sums.addAll(triplets);
        }

        return new ArrayList<>(sums);
    }

    private List<List<Integer>> findPair(int[] nums, int target, int index) {
        List<List<Integer>> sums = new ArrayList<>();
        int left = index + 1;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                sums.add(List.of(-target, nums[left], nums[right]));
            }
            if (sum <= target) {
                left++;
            }
            if (sum >= target) {
                right--;
            }
        }

        return sums;
    }
}
