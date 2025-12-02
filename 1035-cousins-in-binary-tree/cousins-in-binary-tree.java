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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean ParentX=false;
        boolean ParentY=false;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y || curr.left.val==y && curr.right.val==x){
                        return false;
                    }
                }
                if(curr.left!=null){
                    q.add(curr.left);
                    if(curr.left.val==x) ParentX=true;
                    if(curr.left.val==y) ParentY=true;
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    if(curr.right.val==x) ParentX=true;
                    if(curr.right.val==y) ParentY=true;
                }
            }
            if(ParentX && ParentY) return true;
            if(ParentX || ParentY) return false;
        }
        return false;

    }
}