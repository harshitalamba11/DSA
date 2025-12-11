class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i;  // delete all i chars
        for (int j = 0; j <= n; j++) dp[0][j] = j;  // insert all j chars

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];        // no operation
                } else {
                    int insertOp = dp[i][j - 1] + 1;     // insert
                    int deleteOp = dp[i - 1][j] + 1;     // delete
                    int replaceOp = dp[i - 1][j - 1] + 1; // replace

                    dp[i][j] = Math.min(insertOp,
                                 Math.min(deleteOp, replaceOp));
                }
            }
        }

        return dp[m][n];
    }
}
