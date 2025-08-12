class Solution {
    public int lengthOfLIS(int[] nums) {
        Stack<Integer> st=new Stack<>();
        return recur(nums,-1,0,new Integer[nums.length][nums.length+1]);
    }
    public int recur(int[] nums,int prev,int idx,Integer[][] dp){
        if(idx==nums.length) return 0;
        if(dp[idx][prev+1]!=null) return dp[idx][prev+1];  //because -1 se start kia
        int take = 0;
        // choice: take this element if stack empty or it's greater than top
        if(prev==-1 || nums[idx]>nums[prev]){
            take+=1+recur(nums,idx,idx+1,dp);
        }
        int not_take=recur(nums,prev,idx+1,dp);
        return dp[idx][prev+1]=Math.max(take,not_take);
    }
}