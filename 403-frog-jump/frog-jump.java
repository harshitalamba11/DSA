class Solution {
    public boolean result = false;

    public boolean canCross(int[] stones) {

        int n = stones.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return recur(stones, map, 0, 0, dp);
    }

    public boolean recur(int[] stones, Map<Integer, Integer> map,
                         int curr_idx, int prev_jump, int[][] dp) {

        int n = stones.length;

        // memo check
        if (dp[curr_idx][prev_jump] != -1)
            return dp[curr_idx][prev_jump] == 1;

        // reached final stone
        if (curr_idx == n - 1) {
            dp[curr_idx][prev_jump] = 1;
            return true;
        }

        // try jumps
        for (int jump = prev_jump - 1; jump <= prev_jump + 1; jump++) {

            if (jump <= 0) continue;

            int next_pos = stones[curr_idx] + jump;

            if (map.containsKey(next_pos)) {

                int next_idx = map.get(next_pos);

                if (recur(stones, map, next_idx, jump, dp)) {
                    dp[curr_idx][prev_jump] = 1;     // FIXED: store at curr_idx, prev_jump
                    return true;
                }
            }
        }

        dp[curr_idx][prev_jump] = 0;                 // mark as impossible
        return false;
    }
}
