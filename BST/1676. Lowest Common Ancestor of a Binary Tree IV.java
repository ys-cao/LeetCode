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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        
        for (TreeNode node : nodes) {
            set.add(node.val);
        }
        
        return findLCA(root, set);
    }
    
    private TreeNode findLCA(TreeNode node, Set<Integer> set) {
        if (node == null || set.contains(node.val)) return node;
        
        TreeNode left = findLCA(node.left, set);
        TreeNode right = findLCA(node.right, set);
        
        if (left == null) return right;
        if (right == null) return left;
        return node;
    }
}
