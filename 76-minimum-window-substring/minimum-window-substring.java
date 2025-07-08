class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character,Integer> map=new HashMap<>();
        String str="";
        int count=t.length();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left=0;
        int min=Integer.MAX_VALUE;

//right chalte hue map ko minus left meh +
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)>=0){
                    count--;
                }
            }
            while(count==0){
                if(min>right-left+1){
                    min=right-left+1;
                    str=s.substring(left,right+1);
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return str;
    }
}