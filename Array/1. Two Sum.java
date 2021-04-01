class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (hm.containsKey(delta)) {
                return new int[] {hm.get(delta), i};
            }
            
            hm.put(nums[i], i);
        }
        
        return null;
        
        //throw new IllegalArgumentException("No two sum solution.");
    }
}
