class Solution {
    public int coinChange(int[] coins, int amt) {
        int[] list=new int[amt+1];
        if(amt<=0) return 0;
        for(int i=1;i<=amt;i++){
            list[i]=Integer.MAX_VALUE;
            for(int coin:coins){
                if(i>=coin && list[i-coin]!=Integer.MAX_VALUE){
                    list[i]=Math.min(list[i-coin]+1,list[i]);
                }
            }
        }
        if(list[amt]==Integer.MAX_VALUE) return -1;
        return list[amt];
    }
}