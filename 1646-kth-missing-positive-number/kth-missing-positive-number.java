class Solution {
    public int findKthPositive(int[] A, int k) {
        int l=0;
        int h=A.length-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(A[mid]-mid-1<k){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return l + k;
    }
}