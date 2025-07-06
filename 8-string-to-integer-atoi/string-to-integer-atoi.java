class Solution {
    public long helper(String s, int idx, long num) {
        if (idx >= s.length()) return num;

        char ch = s.charAt(idx);
        if (ch >= '0' && ch <= '9') {
            num = num * 10 + (ch - '0');

            // Stop recursion early if already too large
            if (num > (long) Integer.MAX_VALUE + 1) return num;

            return helper(s, idx + 1, num);
        } else {
            return num;
        }
    }

    public int myAtoi(String s1) {
        String s = s1.trim();
        if (s.length() == 0) return 0;

        long res;
        int isneg = 0;

        if (s.charAt(0) == '-') {
            isneg = 1;
            res = helper(s, 1, 0);
        } else if (s.charAt(0) == '+') {
            res = helper(s, 1, 0);
        } else {
            res = helper(s, 0, 0);
        }

        if (isneg == 1) res = -res;

        // Clamp to 32-bit signed int bounds
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int) res;
    }
}
