/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean helper(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
     
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}