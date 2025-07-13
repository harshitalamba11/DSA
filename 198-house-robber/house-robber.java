class Solution {
    public int recur(int[] nums,int idx,int[] dp){
        //method-1 ->>> top-down approach
        if(idx==0) return nums[0];
        if(idx<0){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx]=Math.max((nums[idx]+recur(nums,idx-2,dp)),recur(nums,idx-1,dp));
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return recur(nums,nums.length-1,dp);
    }
}