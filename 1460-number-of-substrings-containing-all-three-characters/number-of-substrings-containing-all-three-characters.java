class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int[] list=new int[3];
        int c=0;
        for(int right=0;right<s.length();right++){
            list[s.charAt(right)-'a']++;   //0,1,2
            while(list[0]>0 && list[1]>0 && list[2]>0){
                c+=s.length()-right;
                list[s.charAt(left)-'a']--;
                left++;
            }
        }
        return c;
    }
}