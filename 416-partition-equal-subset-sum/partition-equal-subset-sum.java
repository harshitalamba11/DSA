class Solution {
    public boolean recur(int[] nums,int target,int sum,int idx,Boolean[][] dp){
        if(idx>=nums.length) return false;
        if(dp[idx][sum]!=null) return dp[idx][sum];
        if(sum==target) return true;
        return dp[idx][sum]=recur(nums,target,sum+nums[idx],idx+1,dp)||recur(nums,target,sum,idx+1,dp);
    }
    public boolean canPartition(int[] nums) {
        int target=0;
        for(int i=0;i<nums.length;i++){
            target+=nums[i];
        }
        if(target%2!=0) return false;
        Boolean[][] dp=new Boolean[nums.length][target+1];
        return recur(nums,target/2,0,0,dp);
    }
}