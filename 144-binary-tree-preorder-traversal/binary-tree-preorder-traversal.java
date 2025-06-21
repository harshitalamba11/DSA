class Solution {
    public void helper(TreeNode root,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        helper(root,res);
        return res;



        // List<Integer> res=new ArrayList<>();
        // if(root==null) return res;
        // TreeNode curr=root;
        // while(curr!=null){
        //     if(curr.left==null){
        //         res.add(curr.val);
        //         curr=curr.right;
        //     }
        //     else{
        //         TreeNode leftChild=curr.left;
        //         while(leftChild.right!=null && leftChild.right!=curr){
        //             leftChild=leftChild.right;
        //         }
        //         if(leftChild.right==null){
        //             res.add(curr.val);
        //             leftChild.right=curr;
        //             curr=curr.left;
        //         }
        //         else{
        //             leftChild.right=null;
        //             curr=curr.right;
        //         }
        //     }
        // }
        // return res;
    }
}