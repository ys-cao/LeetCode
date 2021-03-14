// https://leetcode.com/problems/insert-interval/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        while (i < intervals.length && intervals[i][0] <= newStart) {
            ans.add(intervals[i]);
            i++;
        }
        
        if (ans.isEmpty() || ans.getLast()[1] < newStart) {
            ans.add(newInterval);
        } else {
            ans.getLast()[1] = Math.max(newEnd, ans.getLast()[1]);
        }
        
        while (i < intervals.length) {
            if (intervals[i][0] > ans.getLast()[1]) {
                ans.add(intervals[i]);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], intervals[i][1]);
            }
            i++;
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}
