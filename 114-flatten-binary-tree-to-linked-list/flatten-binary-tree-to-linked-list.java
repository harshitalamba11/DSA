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


 //basically in this approach : hum reverse of postorder follow karte hai postorder banane keh liye...
 //say in this we started with back of right then, left , then root to make it as left right root that is why this is post order strategy...
class Solution {
    public TreeNode prev=null;
    public void flatten(TreeNode root) {
        //using recursion
        //like postorder
        
        TreeNode node=root;
        if(node==null){
            return;
        }

        flatten(node.right);
        flatten(node.left);
        node.right=prev;
        node.left=null;
        prev=node;
    }
}