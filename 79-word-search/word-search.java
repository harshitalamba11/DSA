class Solution {
    public int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word,int i,int j,int idx){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(idx)){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='$';
        for(int[] dir:direction){
            int i_next=i+dir[0];
            int j_next=j+dir[1];
            if(helper(board,word,i_next,j_next,idx+1)) return true;

        }
        board[i][j]=temp;
        return false;
    }
}