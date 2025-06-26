class Solution {
    public void helper(List<List<Integer>> list,List<Integer> curr,int idx,int[] nums){
        list.add(new ArrayList<>(curr));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            helper(list,curr,i+1,nums);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helper(list,curr,0,nums);
        return list;
    }
}