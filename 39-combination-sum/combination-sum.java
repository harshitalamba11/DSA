class Solution {
    public List<List<Integer>> list=new ArrayList<>();
    public void helper(int[] c,int target,int idx,int sum,ArrayList<Integer> curr){
        if(sum>target) return;
        if(sum==target){ 
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<c.length;i++){
            curr.add(c[i]);
            helper(c,target,i,sum+c[i],curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ArrayList<Integer> curr=new ArrayList<>();
        helper(candidates,target,0,0,curr);
        return list;
    }
}