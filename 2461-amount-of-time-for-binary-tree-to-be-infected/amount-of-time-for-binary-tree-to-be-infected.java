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
    public TreeNode findParent(TreeNode root, HashMap<TreeNode, TreeNode> map, int start) {
        if (root == null) return null;
        if (root.val == start) return root;

        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }

        TreeNode leftResult = findParent(root.left, map, start);
        if (leftResult != null) return leftResult;

        return findParent(root.right, map, start);
    }

    public int amountOfTime(TreeNode root, int start) {
        if (root == null) return 0;

        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode startNode = findParent(root, map, start);
        if (startNode == null) return 0; // If the start node is not found

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(startNode);
        visited.add(startNode);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean spread = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Check the parent node
                TreeNode parentNode = map.get(node);
                if (parentNode != null && !visited.contains(parentNode)) {
                    visited.add(parentNode);
                    q.add(parentNode);
                    spread = true;
                }

                // Check the left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                    spread = true;
                }

                // Check the right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                    spread = true;
                }
            }

            if (spread) {
                time++;
            }
        }

        return time;
    }
}