class Solution {
    public boolean helper(int[] nums,int mid,int k){
        int painter=1;
        int s=0;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            if(s>mid){
                s=nums[i];
                painter++;
            }
        }
        return painter<=k;
    }
    public int splitArray(int[] nums, int k) {
        int l=Integer.MIN_VALUE;
        int h=0;
        int ansmin=Integer.MAX_VALUE;
        int sample=ansmin;
        for(int i=0;i<nums.length;i++){
            h+=nums[i];
            l=Math.max(l,nums[i]);
        }
        while(l<=h){
            int mid=(l+h)/2;
            if(helper(nums,mid,k)){
                ansmin=Math.min(mid,ansmin);
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        if(ansmin==sample) return -1;
        return ansmin;
    }
}