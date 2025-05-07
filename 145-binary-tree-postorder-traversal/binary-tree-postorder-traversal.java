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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            // if(curr.left==null){
            //     res.add(curr.val);
            //     curr=curr.right;
            // }
            // else{
            //     TreeNode leftChild=curr.left;
            //     while(leftChild.right!=null){
            //         leftChild=leftChild.right;
            //     }
            //     leftChild.right=curr;
            //     TreeNode temp=curr;
            //     curr=curr.left;
            //     temp.left=null;
            // }
            if(curr.right==null){
                res.add(curr.val);
                curr=curr.left;
            }
            else{
                TreeNode rightChild=curr.right;
                while(rightChild.left!=null && rightChild.left!=curr){
                    rightChild=rightChild.left;
                }
                if(rightChild.left==null){
                    rightChild.left=curr;
                    res.add(curr.val);

                    curr=curr.right;
                }
                else{
                    rightChild.left=null;
                    curr=curr.left;;
                }
            }
        }
        Collections.reverse(res); // Reverse the list at the end
        return res;
    }
}