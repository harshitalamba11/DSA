class Solution {
    public void helper(List<List<Integer>> list,List<Integer> curr,int idx,int k,int n){
        if (k == 0 && n == 0) {
            list.add(new ArrayList<>(curr));
            return;
        }

        if (idx > 9 || k < 0 || n < 0) return;

        helper(list,curr,idx+1,k,n);
        curr.add(idx);
        helper(list,curr,idx+1,k-1,n-idx);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helper(list,curr,1,k,n);
        return list;
    }
}