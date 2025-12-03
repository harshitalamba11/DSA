class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        recur(nums,res,list);
        return res;
    }
    public void recur(int[] nums,List<List<Integer>> res,List<Integer>list){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            recur(nums,res,list);
            list.remove(list.size()-1);
        }
    }
}