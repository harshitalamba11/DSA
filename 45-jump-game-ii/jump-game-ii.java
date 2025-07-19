class Solution {
    public int recur(int[] nums, int n, int idx, int[] dp) {
        if (idx >= n - 1) return 0;  // Already at or beyond the last index → 0 jumps needed

        if (dp[idx] != -1) return dp[idx];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[idx]; i++) {
            int next = idx + i;
            if (next < n) {
                int res = recur(nums, n, next, dp);
                if (res != Integer.MAX_VALUE)
                    min = Math.min(min, res + 1);
            }
        }

        return dp[idx] = min;
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recur(nums, nums.length, 0, dp);
    }
}





/*
class Solution {
    public int min=Integer.MAX_VALUE;
    public void recur(int[] nums,int n,int idx,int c){
        
        if(idx>=n-1){
            min=Math.min(c,min);
            return;
        } 

        for(int i=1;i<=nums[idx];i++){
            recur(nums,n,idx+i,c+1);
        }
    }
    public int jump(int[] nums) {
        recur(nums,nums.length,0,0);
        return min;
    }
}
*/