class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      List<Integer> res=new ArrayList<>();
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
          for(int j=0;j<i;j++){
            if(nums[i]%nums[j]==0)
            dp[i]=Math.max(dp[i],dp[j]+1);
          }
          max=Math.max(max,dp[i]);
        }

        int prev=-1;
        for(int k=dp.length-1;k>=0;k--){
          if(dp[k]==max){
            if(prev==-1){
              res.add(nums[k]);
              prev=nums[k];
              max--;
            }
            else{
              if(prev%nums[k]==0){
                res.add(nums[k]);
                max--;
                prev=nums[k];
              }

            }
          }
        }
        return res;
    }
}