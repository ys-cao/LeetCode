class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            int start_i = intervals[i][0];
            int end_i = intervals[i][1];
            
            for (int j = i + 1; j < intervals.length; j++) {
                int start_j = intervals[j][0];
                int end_j = intervals[j][1];
                if (start_i >= end_j || end_i <= start_j) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
