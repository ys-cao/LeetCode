// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        if (points.length == 0) return 0;
        
        int count = 1;
        
        int overlapStart = points[0][0];
        int overlapEnd = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            
            if (overlapEnd >= points[i][0]) {
                overlapStart = Math.max(overlapStart, points[i][0]);
                overlapEnd = Math.min(overlapEnd, points[i][1]);
            } else {
                count++;
                overlapStart = points[i][0];
                overlapEnd = points[i][1];
            }
            
        }
        
        return count;
    }
}
