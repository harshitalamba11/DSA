class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int months=0;
        Queue<Integer> q=new LinkedList<>();
        int indeg[]=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] d:relations){
            adj.get(d[0]-1).add(d[1]-1);
            indeg[d[1]-1]++;
        }
        int fin[]=new int[n];
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                fin[i]=time[i];
                q.add(i);
            }
        }
        boolean[] vis=new boolean[n];
        
        while(!q.isEmpty()){
            int curr=q.poll();
            months=Math.max(fin[curr],months);
            int max=0;
            for(int des:adj.get(curr)){
                indeg[des]--;
                fin[des]=Math.max(fin[des],fin[curr]+time[des]);
                if(indeg[des]==0){
                    
                    q.add(des);
                }
            }

            // months+=max;
        }
        return months;
        // return fin[n-1];
    }
}