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
    public int maxPathSum(TreeNode root) {
        if ( root.left == null && root.right == null){
            return root.val;
        }
        int[] max = {Integer.MIN_VALUE};
        checkMax(root,max);
        return max[0];
    }
    public int checkMax(TreeNode root,int[] max){
        if ( root == null) return 0;
        // int lh = checkMax(root.left,max);
        // int rh = checkMax(root.right,max);
        int leftMaxPath = Math.max(0, checkMax(root.left, max));
        int rightMaxPath = Math.max(0, checkMax(root.right, max));
        // max = Math.max( max, lh + rh + root.val);
        max[0] = Math.max(max[0], leftMaxPath + rightMaxPath + root.val);

        return Math.max(leftMaxPath, rightMaxPath) + root.val;
    }
}
