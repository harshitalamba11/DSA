class Solution {
    //cost dp meh -1 store kara becoz cost can be 0...
    public int recur(int[] cost,int i,int n,int[] dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=cost[i]+Math.min((recur(cost,i+1,n,dp)),recur(cost,i+2,n,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(recur(cost,0,cost.length,dp),recur(cost,1,cost.length,dp));
    }
}