class Solution {
    public int recur(int[][] obstacleGrid,int m,int n,int row,int col,int[][] dp){
        if(row>=m || col>=n) return 0;
        if(dp[row][col]!=-1) return dp[row][col]; 
        if(obstacleGrid[row][col]==1) return 0;
        if(row==m-1 && col==n-1) return 1;
        return dp[row][col]=recur(obstacleGrid,m,n,row,col+1,dp)+recur(obstacleGrid,m,n,row+1,col,dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(int[] l:dp)Arrays.fill(l,-1);
        return recur(obstacleGrid,obstacleGrid.length,obstacleGrid[0].length,0,0,dp);
    }
}