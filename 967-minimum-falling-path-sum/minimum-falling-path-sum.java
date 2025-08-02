class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Copy last row
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = matrix[n-1][i];
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int down = dp[row + 1][col];
                int leftDiagonal = col > 0 ? dp[row + 1][col - 1] : Integer.MAX_VALUE;
                int rightDiagonal = col < n - 1 ? dp[row + 1][col + 1] : Integer.MAX_VALUE;

                dp[row][col] = matrix[row][col] + Math.min(down, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[0][i]);
        }
        return min;
    }
}
