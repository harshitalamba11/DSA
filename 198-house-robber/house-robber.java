class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return recur(nums,nums.length,dp,0);
    }
    public int recur(int[] nums,int n,int[] dp,int idx){
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int steal=nums[idx]+recur(nums,n,dp,idx+2);
        int not_steal=recur(nums,n,dp,idx+1);
        return dp[idx]=Math.max(steal,not_steal);
    }
}