class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        in(root,ans);
        return ans;
    }
    void in(Node root, ArrayList<Integer> ans){
        if ( root == null) return;
        in(root.left,ans);
        in(root.right,ans);
        ans.add(root.data);
    }
}
