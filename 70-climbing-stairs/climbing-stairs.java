class Solution {
    public int climbStairs(int n){
        int curr=0;
        int next=1;
        int next2=0;
        //back se start
        for(int i=n-1;i>=0;i--){
            curr=next+next2;
            next2=next;
            next=curr;
        }
        return curr;
    }


    // public int recur(int n,int i,int[] dp){
    //     if(i==n){
    //         return 1;
    //     }
    //     if(i>n){
    //         return 0;
    //     }
    //     if(dp[i]!=0) return dp[i];
    //     return dp[i]=recur(n,i+1,dp)+recur(n,i+2,dp);
    // }
    // public int climbStairs(int n) {
    //     int[] dp=new int[n+1];
    //     return recur(n,0,dp);
    // }
}