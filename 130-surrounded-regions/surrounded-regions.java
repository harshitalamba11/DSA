class Solution {
    public void dfs(int row,int col,char[][] mat,boolean[][] vis){
        vis[row][col]=true;
        int m=mat.length;
        int n=mat[0].length;
        int top_row=row-1; int top_col=col;
        if(top_row>=0 && top_row<m && top_col>=0 && top_col<n && !vis[top_row][top_col] && mat[top_row][top_col]=='O'){
            dfs(top_row,top_col,mat,vis);
        }
        int left_row=row; int left_col=col-1;
        if(left_row>=0 && left_row<m && left_col>=0 && left_col<n && !vis[left_row][left_col] && mat[left_row][left_col]=='O'){
            dfs(left_row,left_col,mat,vis);
        }
        int bottom_row=row+1; int bottom_col=col;
        if(bottom_row>=0 && bottom_row<m && bottom_col>=0 && bottom_col<n && !vis[bottom_row][bottom_col] && mat[bottom_row][bottom_col]=='O'){
            dfs(bottom_row,bottom_col,mat,vis);
        }
        int right_row=row; int right_col=col+1;
        if(right_row>=0 && right_row<m && right_col>=0 && right_col<n && !vis[right_row][right_col] && mat[right_row][right_col]=='O'){
            dfs(right_row,right_col,mat,vis);
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        //traverse
        for(int i=0;i<n;i++){
            //first row
            if(board[0][i]=='O' && !vis[0][i]){
                dfs(0,i,board,vis);
            }

            //last row
            if(board[m-1][i]=='O' && !vis[m-1][i]){
                dfs(m-1,i,board,vis);
            }
        }

        for(int j=0;j<m;j++){
            //left side
            if(board[j][0]=='O' && !vis[j][0]){
                dfs(j,0,board,vis);
            }
            
            //right side
            if(board[j][n-1]=='O' && !vis[j][n-1]){
                dfs(j,n-1,board,vis);
            }
        }

        //setting the result but taking the constant complexity for the space in mind
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        // return board;
    }
}