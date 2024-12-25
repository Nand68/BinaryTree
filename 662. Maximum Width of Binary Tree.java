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

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
class Solution {
         public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        // Push the root node and its
        // position (0) into the queue
        q.add(new Pair<>(root, 0));
            int first = 0;
            int last = 0;

        // Perform level-order traversal
        while (!q.isEmpty()) {
            // Get the number of
            // nodes at the current level
            int size = q.size();
            // Get the position of the front
            // node in the current level
            int mmin = q.peek().getValue();

            // Store the first and last positions
            // of nodes in the current level
     

            // Process each node
            // in the current level
            for (int i = 0; i < size; i++) {
                // Calculate current position relative
                // to the minimum position in the level
                int cur_id = q.peek().getValue() - mmin;
                // Get the current node
                TreeNode node = q.peek().getKey(); 
                // Poll the front node from the queue
                q.poll(); 

                // If this is the first node in the level,
                // update the 'first' variable
                if (i == 0) {
                    first = cur_id;
                }

                // If this is the last node in the level,
                // update the 'last' variable
                if (i == size - 1) {
                    last = cur_id;
                }

                // Enqueue the left child of the
                // current node with its position
                if (node.left != null) {
                    q.add(new Pair<>(node.left, cur_id * 2 + 1));
                }

                // Enqueue the right child of the
                // current node with its position
                if (node.right != null) {
                    q.add(new Pair<>(node.right, cur_id * 2 + 2));
                }
            }

            // Update the maximum width by calculating
            // the difference between the first and last
            // positions, and adding 1
            ans = Math.max(ans, last - first + 1);
        }

        // Return the maximum
        // width of the binary tree
        return ans;
         }
}
