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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> curLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        curLevel.push(root);
        boolean normalOrder = true;
        while (!curLevel.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            while(!curLevel.isEmpty()) {
                TreeNode head = curLevel.pop();
                level.add(head.val);
                if (normalOrder) {
                    if (head.left != null) {
                        nextLevel.push(head.left);
                    }
                    if (head.right != null) {
                        nextLevel.push(head.right);
                    }
                } 
                else {
                    if (head.right != null) {
                        nextLevel.push(head.right);
                    }    
                    if (head.left != null) {
                        nextLevel.push(head.left);
                    }
                }
            }
            result.add(level);
            tmp = curLevel;
            curLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }
        return result;
    }
}