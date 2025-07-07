class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int max=0;
        int count_zero=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                count_zero++;
            }
            while(count_zero>k){
                if(nums[left]==0){
                    count_zero--;
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        
        return max;
    }
}