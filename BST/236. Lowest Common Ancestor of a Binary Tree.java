// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

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
        // Use Stack to traverse the tree.
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        // Use HashMap to track all parent nodes.
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        
        stack.push(root);
        parent.put(root, null);
        
        // Traverse tree to find both p and q.
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            } 
            
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            } 
        }
        
        // HashSet for all p's parent node.
        Set<TreeNode> ancestors = new HashSet<>();
        
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        
        return q;
    }
}
