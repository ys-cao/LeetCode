// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        
        TreeNode node = root;
        
        while (node != null) {
            int nodeVal = node.val;
            
            if (pVal > nodeVal && qVal > nodeVal) {
                node = node.right;
            } else if (pVal < nodeVal && qVal < nodeVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        
        return null;
    }
}
