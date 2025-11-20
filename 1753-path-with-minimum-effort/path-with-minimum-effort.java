class Solution {
    public int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public class Triple{
        int source;
        int destination;
        int distance;
        Triple(int source,int destination,int distance){
            this.source=source;this.destination=destination;this.distance=distance;
        }
    }
    public int minimumEffortPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        PriorityQueue<Triple> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Triple(0,0,0));
        while(!pq.isEmpty()){
            Triple curr=pq.poll();
            int src=curr.source;int des=curr.destination;int dis=curr.distance;
            if (src == n-1 && des == m-1) return dis;
            for(int[] dir:dirs){
                int s=src+dir[0];
                int d=des+dir[1];
                if(s>=0 && s<n && d>=0 && d<m){
                    if (dist[s][d] > Math.max(Math.abs(grid[s][d] - grid[src][des]), dist[src][des])) {
                        dist[s][d]=Math.max(Math.abs(grid[s][d]-grid[src][des]),dist[src][des]);
                        pq.add(new Triple(s,d,dist[s][d]));
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
}