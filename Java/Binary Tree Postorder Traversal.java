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
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public void postorder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        postorder(list, root.left);
        postorder(list, root.right);
        list.add(root.val);
    }
     
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postorder(list, root);
        return list;
    }
}