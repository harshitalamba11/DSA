class Solution {
    public class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int c=0;
        int fresh=0;
        int rows=grid.length;
        int cols=grid[0].length;
        int minutes = -1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                else if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            minutes++;
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                for(int[] d:dirs){
                    int rw=curr.i+d[0];
                    int cl=curr.j+d[1];
                    if(rw>=0 && rw<rows && cl>=0 && cl<cols && grid[rw][cl] == 1){
                        grid[rw][cl]=2;
                        fresh--;
                        q.add(new Pair(rw,cl));
                    }
                }
                
            }
        }
        return (fresh == 0) ? minutes : -1;
    }
}