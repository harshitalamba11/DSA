class Solution {
    public int minInsertions(String s) {
        int l=s.length();
        int[][]  dp=new int[l+1][l+1];
        for(int i=0;i<l+1;i++) Arrays.fill(dp[i],-1);
        return recur(s,0,l-1,dp);
    }
    public int recur(String s,int i,int j,int[][] dp){
        if(i==j) return 0;
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=recur(s,i+1,j-1,dp);
        }
        return dp[i][j]=1 + Math.min(recur(s, i+1, j,dp), recur(s, i, j-1,dp));
    }
}