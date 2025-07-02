class Solution {
    public List<List<String>> res=new ArrayList<>();
    public boolean isSafe(List<String> board,int row,int col,int n){
        //for top
        for(int i=row-1;i>=0;i--){
            if(board.get(i).charAt(col)=='Q'){
                return false;
            }
        }
        //for right
        int k=col+1;
        for(int j=row-1;j>=0 && k<n;j--){
            if(board.get(j).charAt(k++)=='Q'){
                return false;
            }
        }
        //for left
        int l=col-1;
        for(int i=row-1;i>=0 && l >= 0;i--){
            if(board.get(i).charAt(l--)=='Q'){
                return false;
            }
        }
        return true;
    }
    public void helper(List<String> board,int n,int row){
        if(row==n){
            res.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<n;col++){
            
            if(isSafe(board,row,col,n)){
                char[] rowChars = ".".repeat(n).toCharArray();
                rowChars[col]='Q';
                board.add(new String(rowChars));
                helper(board,n,row+1);
                board.remove(board.size() - 1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<String> board=new ArrayList<>();
        helper(board, n,0);
        return res;
    }
}