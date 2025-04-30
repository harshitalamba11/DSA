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
    public TreeNode helper(int[] postorder,HashMap<Integer,Integer> map,int rootidx,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(postorder[rootidx]);
        int mid=map.get(root.val);
        root.right=helper(postorder,map,rootidx-1,mid+1,right);
        root.left=helper(postorder,map,rootidx-(right-mid)-1,left,mid-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,map,postorder.length-1,0,postorder.length-1);
    }
}