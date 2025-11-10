class Solution {
    public void dfs(int row,int col,int[][] grid,boolean[][] vis,int[] rowdel,int[] coldel){
        int m=grid.length;
        int n=grid[0].length;
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int r=row+rowdel[i];
            int c=col+coldel[i];
            if(r>=0 && r<m && c>=0 && c<n && !vis[r][c] && grid[r][c]==1){
                dfs(r,c,grid,vis,rowdel,coldel);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int[] rowdel={-1,0,1,0};
        int[] coldel={0,1,0,-1};

        //upper & lower
        for(int i=0;i<n;i++){
            if(grid[0][i]==1 && !vis[0][i]){
                dfs(0,i,grid,vis,rowdel,coldel);
            }
            if(grid[m-1][i]==1 && !vis[m-1][i]){
                dfs(m-1,i,grid,vis,rowdel,coldel);
            }
        }

        //left & right
        for(int i=0;i<m;i++){
            if(grid[i][0]==1 && !vis[i][0]){
                dfs(i,0,grid,vis,rowdel,coldel);
            }
            if(grid[i][n-1]==1 && !vis[i][n-1]){
                dfs(i,n-1,grid,vis,rowdel,coldel);
            }
        }

        //checking the result
        int count=0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}