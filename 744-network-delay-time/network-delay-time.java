class Solution {
    public class Pair{
        int src;int time;
        Pair(int src,int time){
            this.src=src;this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] list:times){
            adj.get(list[0]-1).add(new Pair(list[1]-1,list[2]));
        }
        int time=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Pair(k-1,0));
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=Integer.MAX_VALUE;
        }
        res[k-1]=0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int s=curr.src;
            int t=curr.time;
            for(Pair des:adj.get(s)){
                int new_s=des.src;
                int new_t=des.time;
                if(res[new_s]>res[s]+new_t){
                    res[new_s]=res[s]+new_t;
                    pq.add(new Pair(new_s,res[new_s]));
                }
            }
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            if(res[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(res[i],ans);
        }
        return ans;
    }
}