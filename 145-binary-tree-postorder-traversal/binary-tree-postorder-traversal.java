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
        //using one stack
        Stack<TreeNode> s=new Stack<>();
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        TreeNode curr=root;
        while(curr!=null || !s.isEmpty() ){
            if(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp=s.peek().right;
                if(temp==null){
                    temp=s.pop();
                    // s.pop();
                    list.add(temp.val);
                    while(!s.isEmpty() && temp==s.peek().right){
                        temp=s.pop();
                        list.add(temp.val);
                    }
                }
                else{
                    curr=temp;
                }
            }
        }
        return list;
    }
}







/*
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //using two stacks iterative method
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        List<Integer> l=new ArrayList<>();
        if (root == null) return l;
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode node=s1.pop();
            s2.push(node);
            if(node.left!=null) s1.push(node.left);
            if(node.right!=null) s1.push(node.right);
        }
        while(!s2.isEmpty()){
            TreeNode res=s2.pop();
            l.add(res.val);
        }
        return l;
    }
}
*/



/*
class Solution {
    public void helper(TreeNode root,ArrayList<Integer> res){
        if(root==null) return;
        helper(root.left,res);
        helper(root.right,res);
        res.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        helper(root,res);
        return res;
    }
}
*/