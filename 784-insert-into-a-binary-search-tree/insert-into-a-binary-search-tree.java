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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode newnode=new TreeNode(val);
            return newnode;
        }
        TreeNode curr=root;
        if(val<curr.val){
            if(curr.left==null){
                curr.left=new TreeNode(val);
                return root;
            }
            insertIntoBST(root.left,val);
        }
        if(val>curr.val){
            if(curr.right==null){
                curr.right=new TreeNode(val);
                return root;
            }
            insertIntoBST(curr.right,val);
        }
        return root;
    }
}