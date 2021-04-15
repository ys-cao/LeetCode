/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = addIntegers(l1) + addIntegers(l2);
        
        String sumS = Integer.toString(sum);
        
        ListNode res = new ListNode();
        ListNode dummyHead = new ListNode(0);
        res = dummyHead;
        
        for (int i = sumS.length() - 1; i >= 0; i--) {
            //ListNode n = res;
            int x = (int)sumS.charAt(i);
            res.next = new ListNode(x);
            res = res.next; 
        }
        
        return res;
    }
    
    private int addIntegers(ListNode ln) {
        int sum = 0;
        int size1 = 0; 
        ListNode p = ln;
        while (p != null) {
            size1++;
            p = p.next;
        }
        
        ListNode q = ln;
            
        for (int i = 0; i < size1; i++) {
            sum += q.val * Math.pow(10, size1);
            size1 -= 1;
            q = q.next;
        }
        return sum;
    }
    
} 
