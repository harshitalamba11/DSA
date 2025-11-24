class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        return recur(n,dp,0);
    }
    public int recur(int n,int[] dp,int i){
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp[i]!=0) return dp[i];
        return dp[i]=recur(n,dp,i+1)+recur(n,dp,i+2);
    }
}