// https://leetcode.com/problems/remove-interval/

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> output = new ArrayList<>();
        
        int newStart = toBeRemoved[0];
        int newEnd = toBeRemoved[1];
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            
            if (end <= newStart || start >= newEnd) {
                output.add(Arrays.asList(start, end));
            } else {
                if (start < newStart) output.add(Arrays.asList(start, newStart));
                
                if (end >newEnd) output.add(Arrays.asList(newEnd, end));
            }
        }
        return output;
    }
}
