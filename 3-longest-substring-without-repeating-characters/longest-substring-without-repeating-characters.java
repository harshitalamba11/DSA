class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(set.contains(ch)){
                while(set.contains(ch)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(ch);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}



// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Set<Character> set=new HashSet<>();   //like the element saver , placeholder
//         int left=0;
//         int max=0;
//         for(int right=0;right<s.length();right++){
//             char ch=s.charAt(right);
//             if(set.contains(ch)){
//                 while(set.contains(ch)){
//                     set.remove(s.charAt(left));
//                     left++;
//                 }
//             }
//             set.add(ch);
//             max=Math.max(max,right-left+1);
//         }
//         return max;
//     }
// }