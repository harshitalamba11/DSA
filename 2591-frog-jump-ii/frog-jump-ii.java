class Solution {
    public int maxJump(int[] stones) {
        int max=0;int n=stones.length;
        for(int i=2;i<n;i++){
            max=Math.max(max,stones[i]-stones[i-2]);
        }
        for(int i=1;i<n;i++){
            max=Math.max(max,stones[i]-stones[i-1]);
        }
        return max;
    }
}