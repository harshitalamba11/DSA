class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int target=0;
        for(int i=0;i<n;i++) target+=nums[i];
        Boolean[][] dp=new Boolean[nums.length][target+1];
        if(target%2!=0) return false;
        return recur(nums,target/2,0,dp,0);
    }
    public boolean recur(int[] nums,int target,int sum,Boolean[][] dp,int idx){
        if(idx>=nums.length){
            return false;
        }
        if(sum==target) return true;
        if(dp[idx][sum]!=null) return dp[idx][sum];
        return dp[idx][sum]=recur(nums,target,sum+nums[idx],dp,idx+1)||recur(nums,target,sum,dp,idx+1);
    }
}