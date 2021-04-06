/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        
        inorderIndexMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return arrayToTree(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int[] inorder, int left, int right) {
        
        if (left > right) return null;
        
        int rootValue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootValue);
        
        root.left = arrayToTree(preorder, inorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorder, inorderIndexMap.get(rootValue) + 1, right);
        
        return root;
    }
    
}
