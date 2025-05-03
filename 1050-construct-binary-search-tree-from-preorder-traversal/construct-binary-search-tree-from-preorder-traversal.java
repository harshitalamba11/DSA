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
    public void insertNode(TreeNode root,int val){
        if(root==null) return;
        if(root.val>val){
            if(root.left==null){
                root.left=new TreeNode(val);;
            }
            else{
                insertNode(root.left,val);
            }
        }
        else{
            if(root.right==null){
                root.right=new TreeNode(val);;
            }
            else{
                insertNode(root.right,val);
            }
        }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return null;
        TreeNode root=new TreeNode(preorder[0]);
        TreeNode curr=root;
        for(int i=1;i<preorder.length;i++){
            insertNode(curr,preorder[i]);
        }
        return root;
    }
}