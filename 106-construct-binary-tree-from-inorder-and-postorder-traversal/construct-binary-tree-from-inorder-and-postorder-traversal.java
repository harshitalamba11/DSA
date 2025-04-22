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
    public TreeNode helper(int[] inorder,int[] postorder,Map<Integer,Integer> map,int idx,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(postorder[idx]);
        int mid=map.get(root.val);
        int right_len=right-mid;
        root.right=helper(inorder,postorder,map,idx-1,mid+1,right);
        root.left=helper(inorder,postorder,map,idx-right_len-1,left,mid-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            map.put(inorder[i],i);   //basically map is storing the indexes so that we get the mid from it :)
        }
        return helper(inorder,postorder,map,postorder.length-1,0,postorder.length-1);
    }
}




/*
class Solution {
    public TreeNode helper(int[] inorder,int[] postorder,int in_start,int in_end,int post_start,int post_end){
        if(in_start>in_end) return null;
        TreeNode root=new TreeNode(postorder[post_end]);
        int i=in_start;
        for(;i<=in_end;i++){
            if(inorder[i]==root.val){
                break;
            }
        }
        int leftSize=i-in_start;
        int rightSize=in_end-i;
        root.left = helper(inorder, postorder, in_start, i - 1, post_start, post_start + leftSize - 1);
        root.right = helper(inorder, postorder, i + 1, in_end, post_end - rightSize , post_end - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inorder_len=inorder.length;
        int postorder_len=postorder.length;
        return helper(inorder,postorder,0,inorder_len-1,0,postorder_len-1);
    }
}
*/