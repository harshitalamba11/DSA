class Solution {
    public List<String> helper(String s, List<String> wordDict, int idx) {
        // if (memo.containsKey(idx)) return memo.get(idx);
        
        List<String> res = new ArrayList<>();
        
        if (idx == s.length()) {
            res.add(""); // Base case: empty string as a valid suffix
            return res;
        }

        for (int i = idx + 1; i <= s.length(); i++) {
            String prefix = s.substring(idx, i);
            if (wordDict.contains(prefix)) {
                List<String> suffixes = helper(s, wordDict, i);
                for (String suffix : suffixes) {
                    res.add(prefix + (suffix.equals("") ? "" : " " + suffix));
                }
            }
        }

        // memo.put(idx, res);
        return res;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }
}
