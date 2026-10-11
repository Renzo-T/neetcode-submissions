class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int l = i+1;
            int r = nums.length-1;

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else if (sum == 0) {
                    res.add(List.of(nums[i], nums[l++], nums[r--]));
                    while (nums[l] == nums[l-1] && l < r) {
                        l++;
                    }
                }
            }
        }
        
        return res;
    }
}
