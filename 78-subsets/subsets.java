class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> sublist=new ArrayList<>();
        recur(list,nums,sublist,0);
        return list;
    }
    public void recur(List<List<Integer>> list,int[] nums,List<Integer> sublist,int idx){
        if(idx>=nums.length){
            list.add(new ArrayList<>(sublist));
            return;
        }
        //exclude
        recur(list,nums,sublist,idx+1);
        sublist.add(nums[idx]);
        recur(list,nums,sublist,idx+1);
        sublist.remove(sublist.remove(sublist.size()-1));
    }
}