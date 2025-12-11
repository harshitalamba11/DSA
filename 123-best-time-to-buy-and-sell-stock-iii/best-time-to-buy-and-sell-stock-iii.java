class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length+1][3][3];
        for(int i=0;i<prices.length+1;i++){
            for(int j=0;j<3;j++){
                // for(int k=0;k<3;k++)
                Arrays.fill(dp[i][j],-1);
            }
        }
        return recur(prices,0,2,0,dp);
    }
    public int recur(int[] prices,int idx,int count,int state,int[][][] dp){
        if(idx>=prices.length) return 0;
        if(count==0) return 0;
        if(dp[idx][state][count]!=-1) return dp[idx][state][count];
        int cost=0;
        if(state==0){
            int will_buy=-prices[idx]+recur(prices,idx+1,count,1,dp);
            int will_not_buy=recur(prices,idx+1,count,0,dp);
            cost=Math.max(will_buy,will_not_buy);
        }
        else{
            int will_sell=prices[idx]+recur(prices,idx+1,count-1,0,dp);
            int will_not_sell=recur(prices,idx+1,count,1,dp);
            cost=Math.max(will_sell,will_not_sell);
        }
        return dp[idx][state][count]=cost;
    }
}