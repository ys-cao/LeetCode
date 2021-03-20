// https://leetcode.com/problems/meeting-scheduler/

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));
        
        int i = 0, j = 0;
        
        while(i < slots1.length && j < slots2.length) {
            int interval = Math.min(slots1[i][1], slots2[j][1]) - Math.max(slots1[i][0], slots2[j][0]);
            if (interval >= duration) {
                int min = Math.max(slots1[i][0], slots2[j][0]);
                ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(min, min + duration));
                return result;
            } 
            
            if (slots1[i][1] <slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return new ArrayList<Integer>();
    }
}
