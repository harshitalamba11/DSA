class Solution {
    public int fib(int n){
        int[] dp=new int[n+1];
        return recur(dp,n);
    }
    public int recur(int[] dp,int n) {
        
        if(n<=1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        return dp[n]=recur(dp,n-1)+recur(dp,n-2);

    }
}