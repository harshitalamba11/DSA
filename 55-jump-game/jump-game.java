class Solution {
    public boolean canJump(int[] nums) {
        int idx=0;
        int n=nums.length;
        boolean[] dp=new boolean[nums.length];
        dp[0]=true;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j]==true && j+nums[j]>=i){
                    dp[i]=true;
                }
            }
        }
        return dp[n-1];
    }
}









/*
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
*/