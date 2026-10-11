class Solution {
    public int missingNumber(int[] nums) {
        long sum =  (long) (nums.length/2.0 * (nums.length + 1));
        for (int num : nums) {
            sum -= num;
        }

        return (int) sum;
    }
}
