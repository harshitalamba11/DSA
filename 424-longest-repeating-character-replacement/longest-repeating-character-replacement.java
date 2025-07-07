class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            int windowSize = right - left + 1;

            if (windowSize - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
