//https://leetcode.com/problems/non-overlapping-intervals/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int count = 0, prev = 0;
        
        // i should start from 1 since prev is 0. 
        for (int i = 1; i < intervals.length; i++) {
            // if overlay.
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                count++;
            // No overlap. Move prev to next which is i.
            } else {
                prev = i;
            }
        }
        
        return count; 
    }
}
