class Solution {
    
    public int recur(int[] nums,int n,int[] dp){
        // if(dp[idx]!=-1) return dp[idx];
        for(int i=2;i<=n;i++){
            int not_steal=dp[i-1];
            int steal=0;
            if(i>1)
            steal=dp[i-2]+nums[i-1];
            dp[i]=Math.max(steal,not_steal);
        }
        return dp[n];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        return recur(nums,n,dp);
    }
}