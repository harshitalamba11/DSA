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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s=new Stack<>();
        TreeNode curr=root;
        TreeNode node=root;
        while(curr!=null || !s.isEmpty()){
            while(curr!=null){
            s.push(curr);
            curr=curr.left;
            }
            
                node=s.pop();
                k--;
                if(k==0) return node.val;
            
        curr=node.right;
        }
        return -1;
    }
}