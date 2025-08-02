class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        for(int i=n-2;i>=0;i--){
            List<Integer> currRow=triangle.get(i);
            List<Integer> nextRow=triangle.get(i+1);
            for(int j=0;j<currRow.size();j++){
                int min=Math.min(nextRow.get(j),nextRow.get(j+1));
                currRow.set(j,currRow.get(j)+min);
            }
        }
        return triangle.get(0).get(0);
    }
}