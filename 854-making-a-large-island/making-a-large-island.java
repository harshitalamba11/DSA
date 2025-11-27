class Solution {
    public int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int find(int x,int[] parent){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x],parent);    //path compression
    }
    public void union(int x,int y,int[] parent,int[] rank){
        int p_x=find(x,parent);
        int p_y=find(y,parent);
        if(p_x==p_y) return;
        if(rank[p_x]>rank[p_y]){
            parent[p_y]=p_x;
        }
        else if(rank[p_x]<rank[p_y]){
            parent[p_x]=p_y;
        }
        else{
            parent[p_x]=p_y;
            rank[p_y]++;
        }
    }
    public boolean isValid(int row,int col,int n){
        return row>=0 && row<n && col>=0 && col<n;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int[] rank=new int[n*n];
        int[] parent=new int[n*n];
        for(int i=0;i<n*n;i++) parent[i]=i;
        //step-1
        // making the union
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1){
                    for(int i=0;i<4;i++){
                        int newr=row+dirs[i][0];
                        int newc=col+dirs[i][1];
                        if(isValid(newr,newc,n) && grid[newr][newc]==1){
                            int adj1=row*n+col;
                            int adj2=newr*n+newc;
                            union(adj1,adj2,parent,rank);
                        }
                    }
                }
            }
        }


        //step-2
        // setting the hashmap
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n*n;i++){
            int p=find(i,parent);
            map.put(p,map.getOrDefault(p,0)+1);
        }


        //step-3
        // exactly storing the min higest which can be highest
        int maxres=0;
        for(int val:map.values()){
            maxres=Math.max(maxres,val);
        }


        //step-4 
        // last step trying to flip the 0 to 1
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                if(grid[i][j]==1) continue;
                Set<Integer> s=new HashSet<>();
                max=1;
                if(isValid(i,j,n) && grid[i][j]==0){
                    for(int k=0;k<4;k++){
                        int r=i+dirs[k][0];
                        int c=j+dirs[k][1];
                        if(isValid(r,c,n) && grid[r][c]==1){
                            int p=find(r*n+c,parent);
                            if(s.add(p)){
                                max+=map.get(p);
                            }
                        }
                    }
                }
                maxres=Math.max(max,maxres);
            }
        }
        return maxres;
    }
}