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
  private int postorderIndex;

  private HashMap<Integer, Integer> inorderMap;

  

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    inorderMap = new HashMap<>();

    postorderIndex = postorder.length - 1;

    for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
      
    return arrayToTree(inorder, postorder, 0, inorder.length - 1);
  }
    
 private TreeNode arrayToTree(int[] inorder, int[] postorder, int left, int right) {
    if (left > right) return null;

    int rootValue = postorder[postorderIndex--];
    TreeNode root = new TreeNode(rootValue);


    root.right = arrayToTree(inorder, postorder, inorderMap.get(rootValue) + 1, right);
    root.left = arrayToTree(inorder, postorder, left, inorderMap.get(rootValue) - 1);
      
    return root;
  }
}
