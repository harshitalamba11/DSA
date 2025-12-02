class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(dp[i][j], -1);

        return recur(grid,0,0,m-1,dp);
    }
    public int recur(int[][] grid,int i,int j1,int j2,int[][][] dp){
        int m = grid[0].length;
        int n = grid.length;
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return -100000000;

        if(i==n-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max=-100000000;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int val;
                if(j1==j2) val=grid[i][j1]+recur(grid,i+1,j1+dj1,j2+dj2,dp);
                else val=grid[i][j1]+grid[i][j2]+recur(grid,i+1,j1+dj1,j2+dj2,dp);
                max=Math.max(max,val);
            }
        }
        return dp[i][j1][j2]=max;
    }
}