class Solution {
    public List<List<Integer>> list=new ArrayList<>();
    public void helper(int[] candidates,int target,int idx,int sum,ArrayList<Integer> curr){
        if (sum == target) {
            list.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target) return;
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            curr.add(candidates[i]);
            helper(candidates,target,i+1,sum+candidates[i],curr);
            curr.remove(curr.size()-1);

        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> curr=new ArrayList<>();
        helper(candidates,target,0,0,curr);
        return list;
    }
}