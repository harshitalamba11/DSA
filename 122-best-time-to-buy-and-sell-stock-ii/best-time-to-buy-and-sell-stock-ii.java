class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
            profit+=prices[i]-prices[i-1];
        }
        return profit;
        //successful method-1
        // int sum=0;
        // for(int i=1;i<prices.length;i++){
        //     if(prices[i]>=prices[i-1]){
        //         sum+=(prices[i]-prices[i-1]);
        //     }
        // }
        // return sum;


        //method-2
        // Integer[][] dp=new Integer[prices.length+1][2];
        // return recur(prices,0,1,dp);   //1 for buy 0 for sell


        //method-3
        // int[][] dp=new int[prices.length+1][2];
        // return recur(prices,dp);
    }
    public int recur(int[] prices,int[][] dp){
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==0){
                    int will_buy=-prices[i]+dp[i+1][1];
                    int will_not_buy=0+dp[i+1][0];
                    dp[i][j]=Math.max(will_buy,will_not_buy);
                }
                else{
                    int will_sell=prices[i]+dp[i+1][0];
                    int will_not_sell=0+dp[i+1][1];
                    dp[i][j]=Math.max(will_sell,will_not_sell);
                }
            }        
        }
        
        return dp[0][0];
    }
}