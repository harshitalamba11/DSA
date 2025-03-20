class Solution {
    public boolean helper(int[] nums,int div,int threshold){
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=(nums[i]+div-1)/div;
        }
        if(ans<=threshold){
            return true;
        }
        return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int min=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            // min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int l=min;
        int h=max;
        int ansmin=max;
        while(l<=h){
            int mid=(l+h)/2;
            if(helper(nums,mid,threshold)){
                ansmin=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ansmin;
    }
}