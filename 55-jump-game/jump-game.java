class Solution {
    public boolean recur(int[] nums,int n,int idx,int[] dp){
        if(idx==n-1) return true;
        if(idx>n-1) return false;
        if(dp[idx]!=-1) return dp[idx]==0?false:true;
        for(int i=1;i<=nums[idx];i++){
            if(recur(nums,n,idx+i,dp)==true){
                dp[idx]=1;
                return true;
            } 
        }
        dp[idx]=0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp, -1);
        return recur(nums,nums.length,0,dp);
    }
}