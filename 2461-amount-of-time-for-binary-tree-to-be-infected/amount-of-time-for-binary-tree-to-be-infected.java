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
    public TreeNode parent(HashMap<TreeNode,TreeNode> map,TreeNode root,int start){
        if(root==null) return null;
        if(root.val==start){
            return root;
        }
        if(root.left!=null) map.put(root.left,root);
        if(root.right!=null) map.put(root.right,root);
        TreeNode left=parent(map,root.left,start);
        if(left!=null) return left;
        return parent(map,root.right,start);
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root==null) return 0;
        //first we need to find the starting of this disast..
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        HashSet<TreeNode> visited=new HashSet<>();
        TreeNode startNode=parent(map,root,start);
        if(startNode==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(startNode);
        visited.add(startNode);
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean infect=false;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                //checking for the parent one..
                TreeNode parentNode=map.get(curr);
                if(parentNode!=null && !visited.contains(parentNode)){
                    visited.add(parentNode);
                    infect=true;
                    q.add(parentNode);
                }
                if(curr.left!=null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    infect=true;
                    q.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    infect=true;
                    q.add(curr.right);
                }
            }
            if(infect){
            time++;
            }
        }
        return time;
    }
}