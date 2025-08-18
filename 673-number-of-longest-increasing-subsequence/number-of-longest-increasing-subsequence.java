class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] c=new int[nums.length];
        int[] dp=new int[nums.length];
        Arrays.fill(c,1);
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    c[i]=c[j];
                }
                else if(nums[i]>nums[j] && dp[j]+1==dp[i]){
                    c[i]+=c[j];
                }
            }
            max=Math.max(max,dp[i]);
        }
        int count=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]==max){
                count+=c[i];
            }
        }
        return count;
    }
}