class Solution {
    public class Pair{
        int row;int col;int d;
        Pair(int row,int col,int d){
            this.row=row;this.col=col;this.d=d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if (n == 1) return 1;


        //parameter wali list of list
        int[][] dirs={
            {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
        };

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,1));
        grid[0][0] = 1;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int dist=curr.d;
            for(int[] dir:dirs){
                int new_row=r+dir[0];
                int new_col=c+dir[1];
                if(new_row>=0 && new_row<n && new_col>=0 && new_col<n && grid[new_row][new_col]==0){
                    if(new_row==n-1 && new_col==n-1) return dist+1;
                    q.add(new Pair(new_row,new_col,dist+1));
                    grid[new_row][new_col]=1;
                }
            }
        }

        return -1;
    }
}