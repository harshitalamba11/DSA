class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if (n1 > n2) {
            // nums1 to be smaller
            return findMedianSortedArrays(nums2, nums1);  // This fixes the condition by calling the method with reversed arrays.
        }
        
        int n = n1 + n2;
        int low = 0;
        int high = n1;
        int left = (n + 1) / 2;
        
        while (low <= high) {
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;  // Partition for nums2
            
            if (mid1 < n1) {
                r1 = nums1[mid1];
            }
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }
            if (mid1 > 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 > 0) {
                l2 = nums2[mid2 - 1];
            }
            
            if (l1 <= r2 && l2 <= r1) {  // Correct partition found
                if (n % 2 == 0) {  // Even total length
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2;
                } else {  // Odd total length
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = mid1 - 1;  // Move partition in nums1 to the left
            } else {
                low = mid1 + 1;  // Move partition in nums1 to the right
            }
        }
        return 0;
    }
}
