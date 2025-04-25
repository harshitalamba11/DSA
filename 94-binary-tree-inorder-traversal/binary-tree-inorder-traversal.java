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
        List<Integer> res = new ArrayList<>();
    TreeNode curr = root;

    while (curr != null) {
        if (curr.left == null) {
            res.add(curr.val);  // Visit current
            curr = curr.right;  // Move to right
        } else {
            TreeNode predecessor = curr.left;

            // Find the rightmost node in left subtree or
            // a node that already points to current
            while (predecessor.right != null && predecessor.right != curr) {
                predecessor = predecessor.right;
            }

            if (predecessor.right == null) {
                // Create thread and move to left child
                predecessor.right = curr;
                curr = curr.left;
            } else {
                // Thread already exists - restore tree and visit node
                predecessor.right = null;
                res.add(curr.val);
                curr = curr.right;
            }
        }
    }

    return res;
    }
}