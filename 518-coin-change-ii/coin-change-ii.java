class Solution {
    public int recur(int amount,int[] coins,int sum,int idx,Integer[][] dp){
        if(sum==amount) return 1;
        if (sum > amount || idx >= coins.length) return 0;
        if(dp[idx][sum]!=null) return dp[idx][sum];
        return dp[idx][sum]=recur(amount,coins,sum,idx+1,dp)+ recur(amount,coins,sum+coins[idx],idx,dp);
    }
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return recur(amount,coins,0,0,dp);
    }
}