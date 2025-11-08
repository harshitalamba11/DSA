class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row=image.length;
        int col=image[0].length;
        int[][] floody=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                floody[i][j]=image[i][j];
            }
        }
        int original=image[sr][sc];
        if(original==color) return floody;
        dfs(image,sr,sc,color,floody,row,col,original);
        return floody;
    }
    public void dfs(int[][] image,int sr,int sc,int color,int[][] floody,int row,int col,int original){
        if(sr<0 || sr>=row || sc<0 || sc>=col || image[sr][sc]!=original || floody[sr][sc]==color){
            return;
        }
        floody[sr][sc]=color;
        dfs(image,sr+1,sc,color,floody,row,col,original);
        dfs(image,sr,sc+1,color,floody,row,col,original);
        dfs(image,sr-1,sc,color,floody,row,col,original);
        dfs(image,sr,sc-1,color,floody,row,col,original);
    }
}