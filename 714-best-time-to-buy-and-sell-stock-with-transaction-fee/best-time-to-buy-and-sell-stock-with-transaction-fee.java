class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length+1][2];
        int pro=Integer.MIN_VALUE;
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
            if(j==0){
                int will_buy=-prices[i]+dp[i+1][1];
                int will_not_buy=0+dp[i+1][0];
                dp[i][j]=Math.max(will_buy,will_not_buy);
            }
            else{
                int will_sell=prices[i]+dp[i+1][0]-fee;
                int will_notsell=0+dp[i+1][1];
                dp[i][j]=Math.max(will_sell,will_notsell);
            }
                
            }
        }
        return dp[0][0];
    }
}