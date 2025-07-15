class Solution {
    public int recur(int[] coins,int amount,int idx,Integer[][] dp){
        if(amount==0) return 1;
        if(amount<0) return 0;
        if(idx>=coins.length) return 0;
        if (dp[idx][amount] != null) return dp[idx][amount];
        return dp[idx][amount]=recur(coins,amount-coins[idx],idx,dp)+recur(coins,amount,idx+1,dp);
    }
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return recur(coins,amount,0,dp);
    }
}