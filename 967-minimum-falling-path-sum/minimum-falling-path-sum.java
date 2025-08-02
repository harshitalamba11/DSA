class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix.length];
        int n=matrix.length;
        for(int i=0;i<n;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int down=dp[i+1][j];
                int left_diagonal=j-1>=0?dp[i+1][j-1]:Integer.MAX_VALUE;
                int right_diagonal=j+1<n?dp[i+1][j+1]:Integer.MAX_VALUE;
            
            dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left_diagonal, right_diagonal));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            min=Math.min(min,dp[0][k]);
        }
        return min;
    }
}