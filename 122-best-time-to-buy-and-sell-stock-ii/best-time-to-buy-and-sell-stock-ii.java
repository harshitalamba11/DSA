class Solution {
    public int maxProfit(int[] prices) {

        //successful method-1
        // int sum=0;
        // for(int i=1;i<prices.length;i++){
        //     if(prices[i]>=prices[i-1]){
        //         sum+=(prices[i]-prices[i-1]);
        //     }
        // }
        // return sum;


        //method-2
        Integer[][] dp=new Integer[prices.length+1][2];
        return recur(prices,0,1,dp);   //1 for buy 0 for sell
    }
    public int recur(int[] prices,int idx,int buy,Integer[][] dp){
        if(idx==prices.length) return 0;
        if(dp[idx][buy]!=null) return dp[idx][buy];
        int profit=0;
        if(buy==1){
            int will_buy=-prices[idx]+recur(prices,idx+1,0,dp);
            int will_not_buy=0+recur(prices,idx+1,1,dp);
            profit=Math.max(will_buy,will_not_buy);
        }
        else{
            int will_sell=prices[idx]+recur(prices,idx+1,1,dp);
            int will_not_sell=0+recur(prices,idx+1,0,dp);
            profit=Math.max(will_sell,will_not_sell);
        }
        return dp[idx][buy]=profit;
    }
}