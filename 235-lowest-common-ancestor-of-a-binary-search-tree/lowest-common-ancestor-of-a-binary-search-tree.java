/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root==null) return null;
        // if(root.val==p.val || root.val==q.val) return root;
        // TreeNode left= lowestCommonAncestor(root.left,p,q);
        // TreeNode right=lowestCommonAncestor(root.right,p,q);
        // if(left!=null && right!=null) return root;
        // return left==null?right:left;

        if(root==null) return null;
        TreeNode left=null;
        TreeNode right=null;
        if(root.val==p.val || root.val==q.val) return root;
        if(root.val>p.val){
            left=lowestCommonAncestor(root.left,p,q);
        }
        if(root.val>q.val){
            left=lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<q.val){
            right=lowestCommonAncestor(root.right,p,q);
        }
        if(root.val<p.val){
            right=lowestCommonAncestor(root.right,p,q);
        }
        if(left!=null && right!=null) return root;
        return left==null?right:left;
    }
}