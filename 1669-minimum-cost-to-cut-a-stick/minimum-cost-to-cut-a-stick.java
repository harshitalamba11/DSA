class Solution {
    public int recur(int[] cuts,int l,int r,Integer[][] dp){
        if(r-l<=1) return 0;
        int res=Integer.MAX_VALUE;
        if(dp[l][r]!=null) return dp[l][r];
        for(int i=l+1;i<r;i++){
            int cost=(cuts[r]-cuts[l])+recur(cuts,l,i,dp)+recur(cuts,i,r,dp);
            res=Math.min(cost,res);
        }
        return dp[l][r]=res;
    }
    public int minCost(int n, int[] cut) {
        int[] cuts=new int[cut.length+2];
        Integer[][] dp=new Integer[cuts.length+1][cuts.length+1];
        cuts[0]=0;
        cuts[cuts.length-1]=n;
        for(int i=0;i<cut.length;i++){
            cuts[i+1]=cut[i];
        }
        Arrays.sort(cuts);
        return recur(cuts,0,cuts.length-1,dp);
    }
}