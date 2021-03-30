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
        // Parents for nodes[0].
        Map<TreeNode, TreeNode> parents0 = new HashMap<>();
        
        // Use to traverse the binary tree.
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        parents0.put(root, null);
        stack.push(root);
        
        TreeNode node;
            
        while  (!parents0.containsKey(nodes[0])) {
            node = stack.pop();
            
            if (node.left != null) {
                parents0.put(node.left, node);
                stack.push(node.left);
            } else if (node.right != null) {
                parents0.put(node.right, node);
                stack.push(node.right);
            }
            
        }
        
        
    }
}
