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
    // Pair class to hold node and its horizontal distance
    public class Pair<U, V> {
        public final U first;
        public final V second;

        Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // TreeMap to maintain the order of keys (horizontal distance)
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0)); // Start with the root at horizontal distance 0

        int level = 0; // To track the level of the nodes

        while (!q.isEmpty()) {
            int size = q.size();
            // Temporary map to hold nodes at the same level
            Map<Integer, List<Integer>> levelMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> curr = q.poll();
                TreeNode node = curr.first;
                int hd = curr.second; // Current horizontal distance

                // Add the node value to the level map
                levelMap.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.val);

                // Add left and right children to the queue with updated horizontal distances
                if (node.left != null) {
                    q.add(new Pair<>(node.left, hd - 1));
                }
                if (node.right != null) {
                    q.add(new Pair<>(node.right, hd + 1));
                }
            }

            // Now add the level map to the main map
            for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()) {
                int hd = entry.getKey();
                List<Integer> values = entry.getValue();
                Collections.sort(values); // Sort values at the same horizontal distance
                map.computeIfAbsent(hd, k -> new TreeMap<>()).put(level, values);
            }
            level++; // Increment level for the next iteration
        }

        // Now construct the result from the map
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            for (List<Integer> values : entry.getValue().values()) {
                list.addAll(values);
            }
            res.add(list);
        }
        return res;
    }    }

    // public TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> map= new TreeMap<>(); 
    // public void dfs(TreeNode root,int col,int level){
    //     if(root==null) return;
    //     // insert in map
    //     // col
    //     if(!map.containsKey(col)){
    //         map.put(col,new TreeMap<>()); 
    //     }
    //     if(!map.get(col).containsKey(level)){
    //         map.get(col).put(level,new ArrayList<>());
    //     }
    //     map.get(col).get(level).add(root.val);
    //     dfs(root.left,col-1,level+1);
    //     dfs(root.right,col+1,level+1);
    // }
    // public List<List<Integer>> verticalTraversal(TreeNode root) {
    //     List<List<Integer>> res=new ArrayList<>();
    //     if(root==null) return res;
        
    //     dfs(root,0,0);      //dfs method call having col and level as parameter

    //     // now last step to print
    //     for(Map.Entry<Integer, TreeMap<Integer,ArrayList<Integer>>> entry:map.entrySet()){
    //         TreeMap<Integer,ArrayList<Integer>> levelmap=entry.getValue();
    //         ArrayList<Integer> list=new ArrayList<>();
    //         for(Map.Entry<Integer,ArrayList<Integer>> subentry:levelmap.entrySet()){
    //             ArrayList<Integer> sublist=subentry.getValue();
    //             Collections.sort(sublist);
    //             list.addAll(sublist);
    //         }
    //         res.add(list);
    //     }
    //     return res;
    // }

// }