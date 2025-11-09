class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        // Step 1: Initialize res matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    res[i][j] = 0;
                else
                    res[i][j] = Integer.MAX_VALUE - 1; // prevent overflow
            }
        }

        // Step 2: Top-left pass
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    if (i > 0)
                        res[i][j] = Math.min(res[i][j], res[i-1][j] + 1);
                    if (j > 0)
                        res[i][j] = Math.min(res[i][j], res[i][j-1] + 1);
                }
            }
        }

        // Step 3: Bottom-right pass
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    if (i < m - 1)
                        res[i][j] = Math.min(res[i][j], res[i+1][j] + 1);
                    if (j < n - 1)
                        res[i][j] = Math.min(res[i][j], res[i][j+1] + 1);
                }
            }
        }

        return res;
    }
}
