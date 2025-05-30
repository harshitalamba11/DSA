/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parent(TreeNode root,HashMap<TreeNode,TreeNode> map){
        if(root==null) return;
        if(root.left!=null) map.put(root.left,root);
        if(root.right!=null) map.put(root.right,root);
        parent(root.left,map);
        parent(root.right,map);
        return;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<>();
        HashSet<TreeNode> set=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        if(root==null) return res;
        parent(root,map);
        q.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(k==0) res.add(curr.val);
                 if(root==null) return res;
                set.add(curr);
                if(map.containsKey(curr) && !set.contains(map.get(curr))){
                    q.add(map.get(curr));
                }
                if(curr.left!=null && !set.contains(curr.left)){
                    q.add(curr.left);
                }
                if(curr.right!=null && !set.contains(curr.right)){
                    q.add(curr.right);
                }
                
            }
            k--;if(k<0) break;
        }
        return res;
    }
}