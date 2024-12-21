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
// Solution class
class Solution {
    // Global variable to
    // store the diameter
    int diameter = 0;

    // Function to calculate
    // the height of a subtree
    int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the
        // height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Calculate the diameter at the current
        // node and update the global variable
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height
        // of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Function to find the
    // diameter of a binary tree
    int diameterOfBinaryTree(TreeNode root) {
        // Start the recursive
        // traversal from the root
        calculateHeight(root);

        // Return the maximum diameter
        // found during traversal
        return diameter;
    }
}
