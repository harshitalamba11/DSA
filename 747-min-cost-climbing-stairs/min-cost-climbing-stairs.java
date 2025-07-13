class Solution {

    //method-1 simple neh TLE DIYA....

    //method-2 top-down approach
    //cost dp meh -1 store kara becoz cost can be 0...

    // public int recur(int[] cost,int i,int n,int[] dp){
    //     if(i>=n) return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     return dp[i]=cost[i]+Math.min((recur(cost,i+1,n,dp)),recur(cost,i+2,n,dp));
    // }
    // public int minCostClimbingStairs(int[] cost) {
    //     int[] dp=new int[cost.length];
    //     Arrays.fill(dp, -1);
    ////beacuse 0 and 1 stairs have 0 rupee by mind
    //     return Math.min(recur(cost,0,cost.length,dp),recur(cost,1,cost.length,dp));
    // }



    //method-2 bottome-up approach
    // public int minCostClimbingStairs(int[] cost){
    //     int n=cost.length;
    //     int[] dp=new int[n+1];
    //     dp[0]=0;
    //     dp[1]=0;
    //     for(int i=2;i<=n;i++){
    //         dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
    //     }
    //     return dp[n];
    // }


    //method-3-> space optimizing
    public int minCostClimbingStairs(int[] cost){
        int n=cost.length;
        int prev=0;
        int prev2=0;
        int curr=0;
        for(int i=2;i<=n;i++){
            curr=Math.min(cost[i-1]+prev,cost[i-2]+prev2);
            prev2=prev;
            prev=curr;
        }
        return curr;
    }
}