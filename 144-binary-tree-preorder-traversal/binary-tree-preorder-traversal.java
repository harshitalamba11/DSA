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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        if(root==null){
            return res;
        }
        s.push(root);
        while(!s.isEmpty()){
            TreeNode a=s.pop();
            res.add(a.val);
            if(a.right!=null){
                s.push(a.right);
            }
            if(a.left!=null){
                s.push(a.left);
            }
            
        }
        return res;
    }
}


/*

class Solution {
    public void helper(TreeNode root,List<Integer> r){
        
        if (root==null) return ;
        r.add(root.val);
        helper(root.left,r);
        helper(root.right,r);
    }
    public void iterativeapproach(TreeNode root,List<Integer> r){
        Stack<TreeNode> s=new Stack<>();
        if(root!=null){
            s.push(root);
        }
        while(!s.isEmpty()){
            TreeNode newnode=s.pop();
            r.add(newnode.val);
            if(newnode.right!=null){
                s.push(newnode.right);
            }
            if(newnode.left!=null){
                s.push(newnode.left);
            }
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> r=new ArrayList<>();
        iterativeapproach(root,r);
        return r;
    }
}
*/