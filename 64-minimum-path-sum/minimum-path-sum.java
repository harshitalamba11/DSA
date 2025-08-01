class Solution {
    public int recur(int[][] grid,int m,int n,int min,int row,int col,int sum,int[][] dp){
        if(row>=m || col>=n) return min;
        if(row==m-1 && col==n-1){
            return grid[row][col];
        }
        if (dp[row][col] != -1) return dp[row][col];
        int down=recur(grid,m,n,min,row+1,col,sum,dp);
        int right=recur(grid,m,n,min,row,col+1,sum,dp);
        return dp[row][col] = grid[row][col] + Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        int min=Integer.MAX_VALUE;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int[] l:dp) Arrays.fill(l,-1);
        return recur(grid,m,n,min,0,0,0,dp);
    }
}