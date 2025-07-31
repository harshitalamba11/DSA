class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] list=s.toCharArray();
        char[] list2=t.toCharArray();
        Arrays.sort(list);
        Arrays.sort(list2);
        return Arrays.equals(list,list2);
    }
}