class Solution {
    public class Pair{
        int num;
        int mask;
        Pair(int num,int mask){
            this.num=num;
            this.mask=mask;
        }
    }
    public int shortestPathLength(int[][] graph) {
        //step-01
        //adding the all elements in queue
        int n=graph.length;
        if(n==0 || n==1) return 0;
        Queue<Pair> q=new LinkedList<>();
        int allnodes_mask=(1<<n)-1;
        int[][] vis=new int[n][allnodes_mask+1];
        for(int i=0;i<graph.length;i++){
            q.add(new Pair(i,1<<i));
            vis[i][1<<i]=1;
        }


        //step-02
        //popping the close first element and doing the algo
        int path=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            path++;
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int curr_num=curr.num;
                int curr_mask=curr.mask;
                for(int des:graph[curr_num]){
                    int next_num=des;
                    int next_mask=(1<<des)|curr_mask;
                    if(vis[des][next_mask]==1) continue;
                    if(next_mask==allnodes_mask) return path;
                    q.add(new Pair(next_num,next_mask));
                    vis[next_num][next_mask]=1;
                }
            }
            

        }
        return -1;

    }
}