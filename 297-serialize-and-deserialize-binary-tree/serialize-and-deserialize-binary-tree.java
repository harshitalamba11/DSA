/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return " ";
        StringBuilder str=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                str.append("#,");
                continue;
            }
            str.append(curr.val+",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==" ") { 
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        String[] list=data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        q.add(root);
        
        for(int i=1;i<list.length;i++){
            TreeNode parent=q.poll();
            if (!list[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(list[i]));
                parent.left = left;
                q.add(left);
            }
            if (!list[++i].equals("#")) { // Check for right child
                TreeNode right = new TreeNode(Integer.parseInt(list[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));