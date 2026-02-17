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
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {

            // If left subtree exists
            if (curr.left != null) {

                // Find rightmost node of left subtree
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Attach original right subtree
                prev.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;
                curr.left = null;
            }

            // Move to next node
            curr = curr.right;
        }
    }
}
