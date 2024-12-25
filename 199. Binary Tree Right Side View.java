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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        search(root,ans,0);
        return ans;
    }
    void search(TreeNode root,List<Integer> ans,int level){
        if ( root == null) return;

        if (ans.size() == level){
            ans.add(root.val);
        }
        search(root.right,ans,level+1);
        search(root.left,ans,level+1);

        // for left side view
        // search(root.left,ans,level+1);
        // search(root.right,ans,level+1);
    }
}
