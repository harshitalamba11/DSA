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
    public TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> map= new TreeMap<>(); 
    public void dfs(TreeNode root,int col,int level){
        if(root==null) return;
        // insert in map
        // col
        if(!map.containsKey(col)){
            map.put(col,new TreeMap<>()); 
        }
        if(!map.get(col).containsKey(level)){
            map.get(col).put(level,new ArrayList<>());
        }
        map.get(col).get(level).add(root.val);
        dfs(root.left,col-1,level+1);
        dfs(root.right,col+1,level+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        
        dfs(root,0,0);      //dfs method call having col and level as parameter

        // now last step to print
        for(Map.Entry<Integer, TreeMap<Integer,ArrayList<Integer>>> entry:map.entrySet()){
            TreeMap<Integer,ArrayList<Integer>> levelmap=entry.getValue();
            ArrayList<Integer> list=new ArrayList<>();
            for(Map.Entry<Integer,ArrayList<Integer>> subentry:levelmap.entrySet()){
                ArrayList<Integer> sublist=subentry.getValue();
                Collections.sort(sublist);
                list.addAll(sublist);
            }
            res.add(list);
        }
        return res;
    }

}