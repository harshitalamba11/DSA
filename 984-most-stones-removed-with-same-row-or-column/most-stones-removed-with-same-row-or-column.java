class Solution {
    public void dfs(int[][] stones,boolean[] vis,int idx){
        vis[idx]=true;
        int n=stones.length;
        for(int i=0;i<n;i++){
            int r=stones[idx][0];
            int c=stones[idx][1];
            if (!vis[i] && (stones[i][0] == r || stones[i][1] == c)) {
                dfs(stones,vis,i);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        boolean[] vis=new boolean[n];
        int group=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(stones,vis,i);
                group++;
            }
        }
        return n-group;
    }
}