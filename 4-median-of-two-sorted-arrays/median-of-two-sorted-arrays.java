class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // sorting the array
        int[] arr=new int[nums1.length+nums2.length];
        int idx=0;
        int n1=nums1.length;
        int n2=nums2.length;
        int l=0;
        int h=0;
        int i = 0, j = 0;

        // Merge the two arrays
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                arr[idx++] = nums1[i++];
            } else {
                arr[idx++] = nums2[j++];
            }
        }
        while (i < n1) {
            arr[idx++] = nums1[i++];
        }

        // Add remaining elements from nums2
        while (j < n2) {
            arr[idx++] = nums2[j++];
        }
        if((n1+n2)%2==0){
            int s=(n1+n2)/2;
            double sum=(double)(arr[s]+arr[s-1])/2;
            return sum;
        }
        return arr[(n1+n2)/2];
    }
}