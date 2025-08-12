class Solution {
    public int recur(int[] prices,int[][][] dp){
        for (int i = prices.length-1; i >= 0; i--) {
        for (int j = 0; j <= 1; j++) {
            for (int k = 1; k <= 2; k++) { // k=0 means no transactions left
                if (j == 0) { // can buy
                    int will_buy = -prices[i] + dp[i+1][1][k]; 
                    int will_notbuy = dp[i+1][0][k];
                    dp[i][j][k] = Math.max(will_buy, will_notbuy);
                } else { // can sell
                    int will_sell = prices[i] + dp[i+1][0][k-1]; // reduce transaction after sell
                    int will_notsell = dp[i+1][1][k];
                    dp[i][j][k] = Math.max(will_sell, will_notsell);
                }
            }
        }
    }
    return dp[0][0][2];
    }
    public int maxProfit(int[] prices) {
        // int[][][] dp=new int[prices.length+1][2][3];
        // return recur(prices,dp);


        //method-2
        //four variables
        int profit1=0,profit2=0;
        int min_1=Integer.MAX_VALUE;
        int min_2=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            min_1=Math.min(min_1,prices[i]);
            profit1=Math.max(profit1,prices[i]-min_1);
            min_2=Math.min(min_2,prices[i]-profit1);
            profit2=Math.max(profit2,prices[i]-min_2);
        }
        return profit2;
    }
}