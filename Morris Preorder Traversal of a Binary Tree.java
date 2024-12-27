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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        // Pointer to the current node,
        // starting with the root
        TreeNode cur = root;

        // Iterate until the
        // current node becomes null
        while (cur != null) {
            // If the current node
            // has no left child
            if (cur.left == null) {
                // Add the value of the
                // current node to the preorder list
                preorder.add(cur.val);

                // Move to the right child
                cur = cur.right;
            } else {
                // If the current node has a left child
                // Create a pointer to traverse to the
                // rightmost node in the left subtree
                TreeNode prev = cur.left;

                // Traverse to the rightmost node in the
                // left subtree or until we find a node
                // whose right child is not yet processed
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the right child of the
                // rightmost node is null
                if (prev.right == null) {
                    // Set the right child of the
                    // rightmost node to the current node
                    prev.right = cur;

                    // Move to the left child
                    cur = cur.left;
                } else {
                    // If the right child of the
                    // rightmost node is not null
                    // Reset the right child to null
                    prev.right = null;

                    // Add the value of the
                    // current node to the preorder list
                    preorder.add(cur.val);

                    // Move to the right child
                    cur = cur.right;
                }
            }
        }

        // Return the resulting
        // preorder traversal list
        return preorder;
    }
}
