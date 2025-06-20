class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int max=0;
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            max=Math.max(i-l+1,max);
            set.add(c);
        }
        return max;
    }
}