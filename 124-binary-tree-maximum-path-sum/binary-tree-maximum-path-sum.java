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

//  video link :https://www.youtube.com/watch?v=Op6YFcs8R9M
class Solution {
    public int maxSum;
    public int helper(TreeNode root){
        if(root==null) return 0;
        int l=helper(root.left);
        int h=helper(root.right);
        int neeche_hi_milgaya_ans=l+h+root.val;
        int root_hi_hoga_ans=root.val;
        int l_or_h_koi_ek=Math.max(l,h)+root.val;
        maxSum=Math.max(Math.max(l_or_h_koi_ek,root_hi_hoga_ans),Math.max(neeche_hi_milgaya_ans,maxSum));
        return Math.max(root_hi_hoga_ans,l_or_h_koi_ek);
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }
}