class Solution {
    public List<List<Integer>> list=new ArrayList<>();
    public void helper(int[] candidates,int target,int idx,int sum,ArrayList<Integer> curr){
        if(idx==candidates.length){
            if(sum==target){
                list.add(new ArrayList<>(curr));
            }
            return;
        }
        if(sum + candidates[idx] <= target){
            curr.add(candidates[idx]);
            helper(candidates,target,idx,sum+candidates[idx],curr);
            curr.remove(curr.size()-1);
        }
        helper(candidates,target,idx+1,sum,curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ArrayList<Integer> curr=new ArrayList<>();
        helper(candidates,target,0,0,curr);
        return list;
    }
}