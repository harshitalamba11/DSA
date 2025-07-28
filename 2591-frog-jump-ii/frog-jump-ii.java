class Solution {
    public int maxJump(int[] stones) {
        // int n = stones.length;
        // int maxJump = 0;

        // // Go through the stones with step size 2 (zigzag pattern)
        // for (int i = 2; i < n; i++) {
        //     // Calculate the jump between every alternate stone
        //     maxJump = Math.max(maxJump, stones[i] - stones[i - 2]);
        // }

        // // Also consider the first jump (stone[1] - stone[0])
        // maxJump = Math.max(maxJump, stones[1] - stones[0]);

        // // Also consider the last jump (stone[n-1] - stone[n-2])
        // maxJump = Math.max(maxJump, stones[n - 1] - stones[n - 2]);

        // return maxJump;


        int n=stones.length;
        int maxjump=0;
        for(int i=2;i<n;i++){
            maxjump=Math.max(maxjump,stones[i]-stones[i-2]);
        }
        maxjump=Math.max(maxjump,stones[1]-stones[0]);
        maxjump=Math.max(maxjump,stones[n-1]-stones[n-2]);
        return maxjump;
    }
}
