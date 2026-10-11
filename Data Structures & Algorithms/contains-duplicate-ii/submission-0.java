class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> nearby = new HashSet<>();
        
        for(int i = 0; i < Math.min(k+1, nums.length); i++) {    
            if(!nearby.add(nums[i])) {
                return true;    
            }
        }
        //1,2,3,4,1
        for(int i = k+1; i < nums.length; i++) {
            nearby.remove(nums[i-(k+1)]);
            if(!nearby.add(nums[i])) {
                return true;    
            }
        }

        return false;
    }
}