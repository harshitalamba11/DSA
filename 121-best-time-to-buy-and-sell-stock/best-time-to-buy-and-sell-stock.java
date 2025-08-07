class Solution {
    public int maxProfit(int[] prices) {
        int minval=Integer.MAX_VALUE;
        int maxprofit=Integer.MIN_VALUE;
        for(int num:prices){
            minval=Math.min(minval,num);
            maxprofit=Math.max(maxprofit,num-minval);
        }
        return maxprofit;
    }
}