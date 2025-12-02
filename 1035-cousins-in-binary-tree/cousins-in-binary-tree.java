class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean foundX = false, foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Check siblings
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) ||
                        (curr.left.val == y && curr.right.val == x)) {
                        return false; // siblings → not cousins
                    }
                }

                if (curr.left != null) {
                    q.add(curr.left);
                    if (curr.left.val == x) foundX = true;
                    if (curr.left.val == y) foundY = true;
                }

                if (curr.right != null) {
                    q.add(curr.right);
                    if (curr.right.val == x) foundX = true;
                    if (curr.right.val == y) foundY = true;
                }
            }

            // Both found on same level → C o u s i n s
            if (foundX && foundY) return true;

            // Found only one → not same level → cannot be cousins
            if (foundX || foundY) return false;
        }
        return false;
    }
}
