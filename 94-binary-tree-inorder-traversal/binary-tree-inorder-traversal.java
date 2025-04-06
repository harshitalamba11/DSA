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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> res=new ArrayList<>();
        TreeNode node=root;
        while (true) {
            // Traverse to the leftmost node
            while (node != null) {
                s.push(node);
                node = node.left;
            }

            // If the stack is empty, we are done
            if (s.isEmpty()) {
                break;
            }

            // Process the node
            TreeNode n = s.pop();
            res.add(n.val);

            // Move to the right subtree
            node = n.right; // Update node to the right child
        }

        return res;
    }
}




/*

class Solution {
    public void helper(TreeNode root,List<Integer> res){
        if(root==null) return;
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        helper(root,res);
        return res;
    }
}
*/