// https://leetcode.com/problems/replace-the-substring-for-balanced-string/

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
        
        int count = 0;
        
        for (char c : hm.keySet()) {
            int delta = hm.get(c) - b;
            if (hm.get(c) - b > 0) {
                count += delta;
            }
        }
        
        return count;
    }
}
