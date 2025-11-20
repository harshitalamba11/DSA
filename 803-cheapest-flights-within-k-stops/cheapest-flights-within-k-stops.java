class Solution {
    public class Pair{
        int src;int cost;int stop;
        Pair(int src,int cost,int stop){
            this.src=src;this.cost=cost;this.stop=stop;
        }
    }
    public class adj_Pair{
        int src;int cost;
        adj_Pair(int src,int cost){
            this.src=src;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // making the adj list
        List<List<adj_Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] list:flights){
            adj.get(list[0]).add(new adj_Pair(list[1],list[2]));
        }
        int[][] res=new int[n][k+2];
        for(int i=0;i<n;i++){
            for(int j=0;j<k+2;j++){
                res[i][j]=Integer.MAX_VALUE;
            }
        }
        res[src][0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int s=curr.src;int price=curr.cost;int stops=curr.stop;
            if(s==dst) return price;
            if(stops>k) continue;
            for(adj_Pair des:adj.get(curr.src)){
                int new_src=des.src;
                int new_price=des.cost;
                if(new_price+price<res[new_src][stops+1]){
                    res[new_src][stops+1]=new_price+price;
                    pq.add(new Pair(new_src,new_price+price,stops+1));
                }
            }
        }
        return -1;
    }
}