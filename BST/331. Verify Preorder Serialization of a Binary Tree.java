class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        
        for (int i = 0; i < preorder.length(); i++) {
            if (preorder.charAt(i) == ',') {
                slots--;

                if (slots < 0) return false;

                if (preorder.charAt(i - 1) != '#') slots += 2;
            }
        }
        
        slots = (preorder.charAt(preorder.length() - 1) == '#') ? slots - 1 : slots + 1;
        
        return slots == 0;
    }
}
