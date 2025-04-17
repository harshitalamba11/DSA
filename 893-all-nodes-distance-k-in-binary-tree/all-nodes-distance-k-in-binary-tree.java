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
    public void findParent(HashMap<TreeNode,TreeNode> map,TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            map.put(root.left,root);
        }
        if(root.right!=null){
            map.put(root.right,root);
        }
        findParent(map,root.left);
        findParent(map,root.right);
        return;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<>();
        HashMap<TreeNode,TreeNode> parentMap=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();
        if(root==null) return res;
        findParent(parentMap,root);
        q.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                visited.add(curr);
                if(k==0) res.add(curr.val);
                if(parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))){
                    q.add(parentMap.get(curr));
                }
                if(curr.left!=null && !visited.contains(curr.left)){
                    q.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    q.add(curr.right);
                }
            }
            k--;
            if(k<0) break;
        }
        return res;
    }
}