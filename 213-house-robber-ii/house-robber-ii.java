class Solution {

    //method-1
    // public int recur(int[] num,int n,int[] dp){
    //     if (n <= 0) return 0;
    //     if (n == 1) return num[0];
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n]=Math.max(recur(num,n-1,dp),recur(num,n-2,dp)+num[n-1]);
    // }
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     if (n == 1) return nums[0];
    //     int[] num1=new int[n-1];
    //     int[] num2=new int[n-1];
        // for(int i=0;i<n-1;i++){
        //     num1[i]=nums[i];
        // }
        // for(int i=1;i<n;i++){
        //     num2[i-1]=nums[i];
        // }
        // int[] dp1=new int[n+1];
        // int[] dp2=new int[n+1];
        // Arrays.fill(dp1, -1);
        // Arrays.fill(dp2, -1);
    //     int curr1=recur(num1,n-1,dp1);
    //     int curr2=recur(num2,n-1,dp2);
        
    //     return Math.max(curr1,curr2);
// }


    //method-2
    public int rob(int[] nums){
        int n=nums.length;
        if (n == 1) return nums[0];
        
        if(n==2) return Math.max(nums[0],nums[1]);
        int prev1=nums[0];
        int prev2=Math.max(nums[0],nums[1]);
        int curr=0;
        for(int i=2;i<nums.length-1;i++){
            curr=Math.max(nums[i]+prev1,prev2);
            prev1=prev2;
            prev2=curr;
        }
        int prev21=nums[1];
        int prev22=Math.max(nums[1],nums[2]);
        int curr2=0;
        for(int i=3;i<nums.length;i++){
            curr2=Math.max(nums[i]+prev21,prev22);
            prev21=prev22;
            prev22=curr2;
        }
        return Math.max(prev22,prev2);
    }
    
}