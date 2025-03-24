class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // sorting the array
        int[] arr=new int[nums1.length+nums2.length];
        int idx=0;
        int n1=nums1.length;
        int n2=nums2.length;
        int l=0;
        int h=0;
        while(l<n1 && h<n2){
            if(nums1[l]<nums2[h]){
                arr[idx++]=nums1[l];
                l++;
            }
            else{
                arr[idx++]=nums2[h];
                h++;
            }
        }
        while(l<n1){
            arr[idx++]=nums1[l++];
        }
        while(h<n2){
            arr[idx++]=nums2[h++];
        }
        if((n1+n2)%2==0){
            int s=(n1+n2)/2;
            double sum=(double)(arr[s]+arr[s-1])/2;
            return sum;
        }
        return arr[(n1+n2)/2];
    }
}