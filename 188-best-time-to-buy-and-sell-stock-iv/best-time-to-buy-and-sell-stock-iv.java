class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length+1][2][k+1];
        return recur(prices,dp,k);
    }
    public int recur(int[] prices,int[][][] dp,int u){
        for (int i = prices.length-1; i >= 0; i--) {
        for (int j = 0; j <= 1; j++) {
            for (int k = 1; k <= u; k++) { // k=0 means no transactions left
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
    return dp[0][0][u];
    }
}