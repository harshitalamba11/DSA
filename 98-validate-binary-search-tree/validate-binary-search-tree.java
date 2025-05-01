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
    public boolean check(TreeNode root,long min, long max){
        if(root==null) return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return check(root.left,min,root.val) && check(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);



        // some what incorrect approach
        /*
        if(curr==null) return true;
        if(curr.left==null && curr.right==null)return true;
        if(curr.left!=null && !(curr.left.val<curr.val)){
            return false;
        }
        if(curr.right!=null && !(curr.val<curr.right.val)){
            return false;
        }
        return isValidBST(curr.left) && isValidBST(curr.right);
        */
    }
}