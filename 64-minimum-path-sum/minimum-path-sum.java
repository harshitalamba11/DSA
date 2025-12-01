class Solution {
    public int max_sum=0;
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(grid,n,m,0,0,dp);
    }
    public int recur(int[][] grid,int n,int m,int i,int j,int[][] dp){
        if(i >= n || j >= m) return Integer.MAX_VALUE;
        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1) 
            return dp[i][j];

        int down=recur(grid,n,m,i,j+1,dp);
        int right=recur(grid,n,m,i+1,j,dp);
        return dp[i][j]=grid[i][j]+Math.min(down,right);
    }
}