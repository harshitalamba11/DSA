class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recur(nums,target,0,0);
    }
    public int recur(int[] nums,int target,int idx,int sum){
        int n=nums.length;
        if(idx>=n){
            return (sum==target)?1:0;
        }
        int add=recur(nums,target,idx+1,sum+nums[idx]);
        int sub=recur(nums,target,idx+1,sum-nums[idx]);
        return add+sub;
    }
}