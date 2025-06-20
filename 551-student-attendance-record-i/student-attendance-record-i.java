class Solution {
    public boolean checkRecord(String s) {
        int ab_c = 0;          // Count of 'A'
        int lateStreak = 0;    // Consecutive 'L' count

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'A') {
                ab_c++;
                if (ab_c >= 2) return false;
                lateStreak = 0; // reset streak
            } else if (c == 'L') {
                lateStreak++;
                if (lateStreak >= 3) return false;
            } else {
                lateStreak = 0; // reset streak on 'P'
            }
        }
        return true;
    }
}
