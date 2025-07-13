class Solution {
    //method-1  
    // public int fib(int n){
    //     int[] dp=new int[n+1];
    //     return recur(dp,n);
    // }
    // public int recur(int[] dp,int n) {
        
    //     if(n<=1){
    //         return n;
    //     }
    //     if(dp[n]!=0){
    //         return dp[n];
    //     }
    //     return dp[n]=recur(dp,n-1)+recur(dp,n-2);
    //}

    //method-2
    public int fib(int n){
        int[] dp=new int[n+1];
        if(n<=1) return n;
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    
}