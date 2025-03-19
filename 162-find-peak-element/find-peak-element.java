class Solution {
    public int findPeakElement(int[] nums) {
        int l=0;
        int r=nums.length-1;
        if(nums.length==1){
            return 0;
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){                  //means gir raha hai 
                r=mid-1;
            }
            else if(mid<nums.length-1 && nums[mid]<nums[mid+1]){
                l=mid+1;
            }
            else{
                return mid;
            }
        }
        return nums.length-1;
    }
}