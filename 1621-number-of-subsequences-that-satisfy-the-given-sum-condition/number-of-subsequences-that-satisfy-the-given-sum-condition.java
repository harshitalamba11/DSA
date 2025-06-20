class Solution {
    public int numSubseq(int[] nums, int target) {
        int l=0;
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int r=nums.length-1;
        int c=0;
        int[] pow=new int[nums.length];
        pow[0]=1;
        for(int i=1;i<nums.length;i++){
            pow[i]=pow[i-1]*2%mod;
        }
        while(l<=r){
            if(nums[l]+nums[r]<=target){
                
                c=(c+pow[r-l])%mod;
                l++;
            }
            else{
                r--;
            }
        }
        return c;
    }
}