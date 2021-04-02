class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = 1_000_000_000;
        
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            
            if (!possible(nums, threshold, mi)) {
                lo = mi + 1;   
            } else {
                hi = mi;
            }
        }
        
        return lo;
    }
    
    private boolean possible(int[] nums, int t, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += (i - 1) / k + 1;
        }
        
        return sum <= t;
    }
}
