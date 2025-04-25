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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                res.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode leftChild=curr.left;
                while(leftChild.right!=null && leftChild.right!=curr){
                    leftChild=leftChild.right;
                }
                if(leftChild.right==null){
                    res.add(curr.val);
                    leftChild.right=curr;
                    curr=curr.left;
                }
                else{
                    leftChild.right=null;
                    curr=curr.right;
                }
            }
        }
        return res;
    }
}