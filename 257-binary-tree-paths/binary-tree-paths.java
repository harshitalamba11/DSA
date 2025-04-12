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
    public void search(TreeNode root,List<String> res,String str){
        if(root.left==null && root.right==null) res.add(str+root.val);
        if(root.left!=null) search(root.left,res,str+root.val+"->");
        if(root.right!=null) search(root.right,res,str+root.val+"->");
    }
    public List<String> binaryTreePaths(TreeNode root) {
        String str="";
        List<String> res=new ArrayList<>();
        search(root,res,str);
        return res;
    }
}