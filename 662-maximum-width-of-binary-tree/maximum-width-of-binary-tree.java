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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        q.add(new Pair<>(root,0));
        int maxwidth=0;
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode firstNode=q.peek().getKey();
            TreeNode curr=firstNode;
            int firstidx=q.peek().getValue();
            int lastidx=firstidx;
            for(int i=0;i<size;i++){
                TreeNode curr1=q.peek().getKey();
                lastidx=q.poll().getValue();
                if(curr1.left!=null){
                    q.add(new Pair<>(curr1.left,2*lastidx));
                }
                if(curr1.right!=null){
                    q.add(new Pair<>(curr1.right,2*lastidx+1));
                }
            }
            maxwidth=Math.max(maxwidth,lastidx-firstidx+1);
        }
        return maxwidth;



        // if(root==null) return 0;
        // int maxwidth=0;
        // TreeNode curr=root;
        // Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        // q.add(new Pair<>(curr,0));
        // while(!q.isEmpty()){
        //     TreeNode currNode=q.peek().getKey();
        //     int leftidx=q.peek().getValue();
        //     int rightidx=leftidx;
        //     int size=q.size();
        //     for(int i=0;i<size;i++){
        //         Pair<TreeNode,Integer> p=q.poll();
        //         TreeNode leftNode=p.getKey();
        //         int curridx=p.getValue();
        //         rightidx=curridx;
        //         if(leftNode.left!=null){
        //             q.add(new Pair<>(leftNode.left,2*curridx));
        //         }
        //         if(leftNode.right!=null){
        //             q.add(new Pair<>(leftNode.right,2*curridx+1));
        //         }
        //     }
            
        // maxwidth=Math.max(maxwidth,rightidx-leftidx+1);
        // }
        // return maxwidth;
    }
}