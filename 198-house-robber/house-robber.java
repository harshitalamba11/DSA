class Solution {
    // public int recur(int[] nums,int idx,int[] dp){
    //     //method-1 ->>> top-down approach
    //     if(idx==0) return nums[0];
    //     if(idx<0){
    //         return 0;
    //     }
    //     if(dp[idx]!=-1) return dp[idx];
    //     return dp[idx]=Math.max((nums[idx]+recur(nums,idx-2,dp)),recur(nums,idx-1,dp));
    // }
    // public int rob(int[] nums) {
    //     int[] dp=new int[nums.length+1];
    //     Arrays.fill(dp,-1);
    //     return recur(nums,nums.length-1,dp);
    // }



    //method-2 ->>> bottome-up approach
    // public int rob(int[] nums) {
    //     int[] dp=new int[nums.length+1];
    //     if(nums.length==1) return nums[0];
    //     if(nums.length<=2) return Math.max(nums[0],nums[1]);
    //     dp[0]=nums[0];dp[1]=Math.max(nums[0],nums[1]);
    //     for(int i=2;i<nums.length;i++){
    //         dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
    //     }
    //     return dp[nums.length-1];
    // }


    //method-3 ->>> space-complexity
    // public int rob(int[] nums){
    //     int prev=nums[0];
    //     if(nums.length==1) return nums[0];
    //     if(nums.length==2) return Math.max(nums[0],nums[1]);
    //     int next=Math.max(nums[0],nums[1]);
    //     int curr=0;
    
    //     for(int i=2;i<nums.length;i++){
    //         curr=Math.max(nums[i]+prev,next);
    //         prev=next;
    //         next=curr;
    //     }
    //     return curr;
    // }

    public int recur(int[] nums,int idx,int n,int[] dp){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx]=Math.max(nums[idx]+recur(nums,idx+2,n,dp),recur(nums,idx+1,n,dp));
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return recur(nums,0,nums.length,dp);
    }
    
}