class Solution {
    public boolean helper(int[] weights,int div,int days){
        int c=0;
        int d=1;    //if start with d=0;   then return should be d<days
        for(int i=0;i<weights.length;i++){
            c+=weights[i];
            if(c>div){
                c = weights[i];
                d++;
            }
        }
        return d<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max_num=Integer.MIN_VALUE;
        int size=0;
        for(int i=0;i<weights.length;i++){
            size+=weights[i];
            max_num=Math.max(max_num,weights[i]);
        }
        int l=max_num;
        int h=size;
        int ans_min=Integer.MAX_VALUE;
        while(l<=h){
            int mid=(l+h)/2;
            if(helper(weights,mid,days)){
                ans_min=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans_min;
    }
}