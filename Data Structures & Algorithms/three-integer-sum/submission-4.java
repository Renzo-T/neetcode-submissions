class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            List<List<Integer>> triplets = findTriplets(nums, i);
            res.addAll(triplets);
        }

        return res;
    }

    private List<List<Integer>> findTriplets(int[] nums, int leftIdx) {
        List<List<Integer>> res = new ArrayList();
        int firstNum = nums[leftIdx];
        int rightIdx = nums.length - 1;
        leftIdx++;
        while (leftIdx < rightIdx) {
            int sumOfPointers = firstNum + nums[leftIdx] + nums[rightIdx];
            if (sumOfPointers == 0) {
                res.add(
                    List.of(firstNum, nums[leftIdx], nums[rightIdx])
                );
                leftIdx++;
                rightIdx--;
                while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx-1]) {
                    leftIdx++;
                }
            } else if (sumOfPointers < 0) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        return res;
    }
}
