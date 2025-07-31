class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }
        Set<Integer> res=new HashSet<>();
        for(int num:set1){
            if(set2.contains(num)){
                res.add(num);
            }
        }
        int[] list=new int[res.size()];
        int idx=0;
        for(int num:res){
            list[idx]=num;
            idx++;
        }
        return list;
    }
}