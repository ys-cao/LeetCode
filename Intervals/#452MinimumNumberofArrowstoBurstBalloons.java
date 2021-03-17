// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        /*Arrays.sort(points, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
        // Sort by start point.
        // If two intervals share the same start point,
        // put the longer one to be the first.
            return o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0];
            }
        });*/
        
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
            
            
            /*if (points[prev][1] < points[i][0]) {
                prev = i;
                count++;
                
                overlapStart = points[i][0];
                overlapEnd = points[i][1];
            } else {  // When there is a overlap.
                
                if (points[i][0] >= overlapStart && points[i][0] <= overlapEnd) {
                    overlapStart = Math.max(overlapStart, points[i][0]);
                    overlapEnd = Math.min(overlapEnd, points[i][1]);
                } else {
                    prev = i;
                    count++;
                    
                    overlapStart = points[i][0];
                overlapEnd = points[i][1];
                }
            }*/
            
        }
        
        return count;
    }
}
