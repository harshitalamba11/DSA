class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        for(int i=0;i<prices.length+1;i++) Arrays.fill(dp[i],-1);
        return recur(prices,0,0,dp);
    }
    public int recur(int[] prices,int state,int idx,int[][] dp){
        if(idx>=prices.length) return 0;
        int cost=0;
        if(dp[idx][state]!=-1) return dp[idx][state];
        if(state==0){
            int will_buy=-prices[idx]+recur(prices,1,idx+1,dp);
            int will_not_buy=recur(prices,0,idx+1,dp);
            cost=Math.max(will_buy,will_not_buy);
        }
        else{
            int will_sell=prices[idx]+recur(prices,0,idx+1,dp);
            int will_not_sell=recur(prices,1,idx+1,dp);
            cost=Math.max(will_sell,will_not_sell);
        }
        return dp[idx][state] = cost;
    }
}