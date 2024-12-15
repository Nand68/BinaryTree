class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        in(root,ans);
        return ans;
    }
    void in(Node root, ArrayList<Integer> ans){
        if ( root == null) return;
        in(root.left,ans);
        ans.add(root.data);
        in(root.right,ans);
    }
}
