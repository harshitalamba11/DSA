class Solution {
    public boolean helper(int[] arr,int j,int m,int k){
        int c=0;
        int sum=0;
        for(int k_=0;k_<arr.length;k_++){
            if(arr[k_]<=j){
                c++;
            }
            else{
                sum=sum+(c/k);
                c=0;
            } 
        }
        // if(sum>=m)
        sum+=(c/k);
        return sum>=m;
        // else
    }
    public int minDays(int[] bloomDay, int m, int k) {
        //finding the minimum and maximum
        int minday=Integer.MAX_VALUE;
        int n=bloomDay.length;
        long val = (long) m * k;
        if (val > n) return -1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        // for(int j=min;j<=max;j++){
        //    if(helper(bloomDay,j,m,k)){
        //      minday=Math.min(minday,j);
        //    }
        // }
        int l=min;
        int h=max;
        while(l<=h){
            int mid=(l+h)/2;
            if(helper(bloomDay,mid,m,k)){
                minday=Math.min(minday,mid);
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return minday;
    }
}