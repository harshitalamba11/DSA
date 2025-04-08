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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int flag=0;  //left to right
        while(!q.isEmpty()){
            int currentsize=q.size();
            List<Integer> r=new ArrayList<>();
            for(int i=0;i<currentsize;i++){
                TreeNode curr=q.remove();
                if(flag==0){
                r.add(curr.val);
                // flag=1;
                }
                else{
                r.add(0,curr.val);
                // flag=0;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                
            }
            if(flag==0) flag=1;
                else{flag=0;}
            res.add(r);
        }
        return res;
    }
}