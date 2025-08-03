class Solution {
    public int countPartitions(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int c=0;
        for(int i=0;i<nums.length-1;i++){
            int left=nums[i];
            int right=total-nums[i];
            if((Math.abs(right-left))%2==0) c++;
        }
        return c;
    }
}