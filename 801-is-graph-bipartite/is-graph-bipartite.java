class Solution {
    public boolean dfs(int[] color,int[][] graph,int curr,int currcolor){
        color[curr]=currcolor;
        for(int des:graph[curr]){
            if(color[des]==currcolor){
                return false;
            }
            else if(color[des]==-1){
                color[des]=1-currcolor;
                if(!dfs(color,graph,des,1-currcolor)) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        //dfs 
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1)
            if(!dfs(color,graph,i,0)) return false;
        }
        return true;
    }
}