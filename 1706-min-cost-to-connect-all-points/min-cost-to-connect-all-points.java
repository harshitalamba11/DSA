class Solution {
    public class Pair{
        int src;int w;
        Pair(int src,int w){
            this.src=src;
            this.w=w;
        }
    }
    public class trio{
        int src;int parent;int w;
        trio(int src,int parent,int w){
            this.w=w;this.src=src;this.parent=parent;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int d=Math.abs(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]));
                adj.get(i).add(new Pair(j,d));
                adj.get(j).add(new Pair(i,d));
            }
        }
        int mincost=0;
        PriorityQueue<trio> q=new PriorityQueue<>((a,b)->a.w-b.w);
        boolean[] vis=new boolean[n];
        q.add(new trio(0,-1,0));
        while(!q.isEmpty()){
            trio curr=q.poll();
            if(!vis[curr.src]){
                mincost+=curr.w;
                vis[curr.src]=true;
                for(Pair d:adj.get(curr.src)){
                    q.add(new trio(d.src,curr.src,d.w));
                }
            }
        }
        return mincost;
    }
}