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
    public TreeNode binary(int[] preorder,HashMap<Integer,Integer> map,int rootidx,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(preorder[rootidx]);
        int mid = map.get(preorder[rootidx]);
        root.left=binary(preorder,map,rootidx+1,left,mid-1);
        root.right=binary(preorder,map,rootidx+(mid-left+1),mid+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return binary(preorder,map,0,0,inorder.length-1);
    }
}