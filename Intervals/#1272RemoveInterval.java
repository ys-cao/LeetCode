// https://leetcode.com/problems/remove-interval/

class Solution {
    public int balancedString(String s) {
        if (s.length() % 4 != 0) System.out.println("Invalid String Length.");
        
        Map<Character, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }
        }
        
        // Balanced number of characters.
        int b = s.length() / 4;
        
        int min = 0;
        
        List<Character> over = new ArrayList<>();
        
        for (char c : hm.keySet()) {
            int delta = hm.get(c) - b;
            if (hm.get(c) - b > 0) {
                min += delta;
                over.add(c);
            }
        }
        
        int temp = 0, max = 0, index = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (over.contains(c)) {
                temp++;
            } else {
                temp--;
                if (temp < 0) temp = 0;
            }
    
            if (temp == min) return min;
            
            if (temp > max) {
                max = temp;
                index = i;
            }
        }
        
        
    }
}
