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
    // public void inorder(TreeNode root,HashSet<Integer> list){
    //     if(root==null) return;
    //     inorder(root.left,list);
    //     list.add(root.val);
    //     inorder(root.right,list);
    // }
    // public boolean findTarget(TreeNode root, int k) {
    //     // if (root == null) return false;
    //     HashSet<Integer> list=new HashSet<>();
    //     TreeNode curr=root;
    //     inorder(curr,list);
    //     for(int num:list){
    //         if(list.contains(k-num) && (k-num!=num)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public HashSet<Integer> set=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        
        if(set.contains(k-root.val)){return true;}
        set.add(root.val);
        return findTarget(root.left,k)|| findTarget(root.right,k);
    }
}