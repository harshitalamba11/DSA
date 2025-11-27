class Solution {
    public class Pair{
        int row;int col;int h;
        Pair(int row,int col,int h){
            this.row=row;
            this.col=col;
            this.h=h;
        }
    }
    public int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
    public int swimInWater(int[][] grid) {
        int maxheight=0;
        int n=grid.length;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.h-b.h);
        q.add(new Pair(0,0,grid[0][0]));
        boolean[][] vis=new boolean[n][n];
        while(!q.isEmpty()){
            Pair curr=q.poll();
            vis[curr.row][curr.col]=true;
            maxheight=Math.max(maxheight,curr.h);
            if(curr.row==n-1 && curr.col==n-1) return maxheight;
            for(int i=0;i<4;i++){
                int new_r=curr.row+dirs[i][0];
                int new_c=curr.col+dirs[i][1];
                if(new_r>=0 && new_c>=0 && new_r<n && new_c<n){
                    if(!vis[new_r][new_c]){
                        q.add(new Pair(new_r,new_c,grid[new_r][new_c]));
                    }
                }
            }
        }
        return maxheight;
    }
}