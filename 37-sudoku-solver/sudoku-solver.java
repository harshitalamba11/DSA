class Solution {
    public boolean issafe(int i,char[][] board,int row,int col){
        char ch = (char) (i + '0');
        for (int _i = 0; _i < board.length; _i++) {
            if (board[row][_i] == ch) return false;
        }
        for (int _i = 0; _i < board[0].length; _i++) {
            if (board[_i][col] == ch) return false;
        }
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        for (int i_ = 0; i_ < 3; i_++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i_][startCol + j] == ch) return false;
            }
        }
        return true;
    }
    public boolean solve(char[][] board,int m,int n,int row,int col){
        if(row==m){
            return true;
        }
        int rownext=(col==n-1?row+1:row);
        int colnext=(col==n-1?0:col+1);
        if(board[row][col]!='.'){
            return solve(board,m,n,rownext,colnext);
        }
        for(int i=1;i<=9;i++){
            if(issafe(i,board,row,col)){
                board[row][col]=(char)(i+'0');
                if(solve(board,m,n,rownext,colnext)) return true;
                board[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board,board.length,board[0].length,0,0);
    }
}