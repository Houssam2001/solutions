class Solution {
    private Integer prev; // variable to store the previously visited node value

    public boolean isValidBST(TreeNode root) {
        // initialize prev variable as null before starting the traversal
        prev = null;
        // start the inorder traversal from the root node
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode node) {
        // base case
        if (node == null) {
            return true;
        }
        // recursively traverse the left subtree
        if (!inorderTraversal(node.left)) {
            return false;
        }
        // check if the current node's value is greater than the previous node's value (if any)
        if (prev != null && node.val <= prev) {
            return false;
        }
        prev = node.val; // update prev to the current node's value
        // recursively traverse the right subtree
        return inorderTraversal(node.right);
    }
}
