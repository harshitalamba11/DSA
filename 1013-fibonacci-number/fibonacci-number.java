class Solution {
    public int fib(int n) {
        int[] dp=new int[n+1];
        //using recur simple because understanding dp
        return recur(n,dp);
    }
    public int recur(int n,int[] dp){
        if(n==0) return dp[0]=0;
        if(n<=1){
            return dp[n]=1;
        }
        if(dp[n]!=0) return dp[n];
        return dp[n]=recur(n-1,dp)+recur(n-2,dp);
    }
}