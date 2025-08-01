class Solution {
    public int recur(int m,int n,int row,int col,int[][] dp){
        if(row >= m || col >= n) return 0;
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        int right=recur(m,n,row,col+1,dp);
        int down=recur(m,n,row+1,col,dp);
        return dp[row][col]=right+down;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return recur(m,n,0,0,dp);
    }
}