class Solution {
    // Function to check if a binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        // If the tree is empty, it's balanced
        if (root == null) {
            return true;
        }

        // Calculate the height of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Check if the absolute difference in heights
        // of left and right subtrees is <= 1
        if (Math.abs(leftHeight - rightHeight) <= 1 &&
            isBalanced(root.left) &&
            isBalanced(root.right)) {
            return true;
        }

        // If any condition fails, the tree is unbalanced
        return false;
    }

    // Function to calculate the height of a subtree
    public int getHeight(TreeNode root) {
        // Base case: if the current node is NULL,
        // return 0 (height of an empty tree)
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height
        // of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Return the maximum height of left and right subtrees
        // plus 1 (to account for the current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}


/////////////


class Solution {

    // Function to check if a binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        // Check if the tree's height difference
        // between subtrees is less than 2
        // If not, return false; otherwise, return true
        return dfsHeight(root) != -1;
    }

    // Recursive function to calculate
    // the height of the tree
    public int dfsHeight(TreeNode root) {
        // Base case: if the current node is NULL,
        // return 0 (height of an empty tree)
        if (root == null) return 0;

        // Recursively calculate the
        // height of the left subtree
        int leftHeight = dfsHeight(root.left);

        // If the left subtree is unbalanced,
        // propagate the unbalance status
        if (leftHeight == -1) 
            return -1;

        // Recursively calculate the
        // height of the right subtree
        int rightHeight = dfsHeight(root.right);

        // If the right subtree is unbalanced,
        // propagate the unbalance status
        if (rightHeight == -1) 
            return -1;

        // Check if the difference in height between
        // left and right subtrees is greater than 1
        // If it's greater, the tree is unbalanced,
        // return -1 to propagate the unbalance status
        if (Math.abs(leftHeight - rightHeight) > 1)  
            return -1;

        // Return the maximum height of left and
        // right subtrees, adding 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
