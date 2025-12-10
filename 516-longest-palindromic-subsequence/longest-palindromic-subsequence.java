class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length()<=1)return 1;
        int i=0;
        int j=s.length()-1;
        int[][] dp=new int[s.length()+1][s.length()+1];
        for(int i1=0;i1<s.length()+1;i1++) Arrays.fill(dp[i1],-1);
        return recur(s,i,j,dp);
    }
    public int recur(String s, int i,int j,int[][] dp){
        if(i>j)return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=2+recur(s,i+1,j-1,dp);
        }
        int a=recur(s,i+1,j,dp);
        int b=recur(s,i,j-1,dp);
        return dp[i][j]=Math.max(a,b);
    }
}