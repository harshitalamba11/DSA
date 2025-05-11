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
    public TreeNode target=null;
    public void parent(TreeNode root,HashMap<TreeNode,TreeNode> map,int start){
        if(root==null) return;
        if(root.val==start) target=root;
        if(root.left!=null) map.put(root.left,root);
        if(root.right!=null) map.put(root.right,root);
        parent(root.left,map,start);
        parent(root.right,map,start);
        return;
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root==null) return 0;
        int time=0;
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        parent(root,map,start);
        q.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            boolean flag=false;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                visited.add(curr);
                if(map.containsKey(curr) && !visited.contains(map.get(curr))){
                    q.add(map.get(curr));
                    flag=true;
                }
                if((curr.left!=null) && !visited.contains(curr.left)){
                    q.add(curr.left);
                    flag=true;
                }
                if((curr.right!=null) && !visited.contains(curr.right)){
                    q.add(curr.right);
                    flag=true;
                }
            }
            if(flag)
            time++;
        }
        return time;
    }
}