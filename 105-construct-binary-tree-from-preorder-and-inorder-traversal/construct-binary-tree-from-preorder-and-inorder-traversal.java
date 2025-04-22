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
    //root is rootidx
    public TreeNode helper(int[] preorder,int[] inorder,Map<Integer,Integer> map,int rootidx,int left,int right){
        if (left > right) {
            return null; // If no nodes to process, return null
        }

        TreeNode root = new TreeNode(preorder[rootidx]);
        int mid = map.get(preorder[rootidx]);
        
        // Left subtree: Increase rootidx by 1 as we move to the next node in preorder
        root.left = helper(preorder, inorder, map, rootidx + 1, left, mid - 1);
        
        // Right subtree: rootidx is incremented by the number of nodes in the left subtree
        root.right = helper(preorder, inorder, map, rootidx + (mid - left + 1), mid + 1, right);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,inorder,map,0,0,inorder.length-1);
    }
}