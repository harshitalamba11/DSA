class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums,int k){
        int left=0;
        int count=0; //odd ones
        int p=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]%2!=0){
                count++;
            }
            while(count>k && left<=right){
                if(nums[left]%2!=0){
                    count--;
                }
                left++;
            }
            p+=right-left+1;
        }
        return p;
    }
}