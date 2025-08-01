class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxcount=1;
        int streak=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) continue;
            else if(nums[i]==nums[i-1]+1){
                streak++;
            }
            else{
                maxcount=Math.max(streak,maxcount);
                streak=1;
            }
        }
        maxcount=Math.max(maxcount,streak);
        return maxcount;
    }
}