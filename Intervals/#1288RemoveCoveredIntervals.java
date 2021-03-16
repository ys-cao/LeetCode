// https://leetcode.com/problems/remove-covered-intervals/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        //Comparator<int[]> c1 = Comparator.comparing((a, b) -> Integer.compare(a[0], b[0]));
        //Comparator<int[]> c2 = Comparator.comparing((a, b) -> Integer.compare(a[1], b[1]));
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int prev = 0;
        int countRemoval = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][0] && intervals[i][1] <= intervals[prev][1]) {
                countRemoval++;
            } else if (intervals[i][0] <= intervals[prev][0] && intervals[i][1] >= intervals[prev][1]) {
                countRemoval++;
                prev = i;
            } else {
                prev = i;
            }
        }
        
        return (intervals.length - countRemoval);
    }
}
