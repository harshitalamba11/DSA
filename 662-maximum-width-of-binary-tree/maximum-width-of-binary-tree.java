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
        int maxwidth=0;
        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int leftidx=q.peek().getValue();
            int rightidx=leftidx;
            for(int i=0;i<size;i++){
                Pair<TreeNode,Integer> current=q.poll();
                TreeNode currentnode=current.getKey();
                int currentidx=current.getValue();
                rightidx=currentidx;
                if(currentnode.left!=null){
                    q.add(new Pair<>(currentnode.left,2*currentidx));
                }
                if(currentnode.right!=null){
                    q.add(new Pair<>(currentnode.right, 2 * currentidx + 1));
                }
            }
            maxwidth=Math.max(maxwidth,rightidx-leftidx+1);
        }
        return maxwidth;
    }
}