class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.contains(ch)){
                while(!st.isEmpty() && st.peek()>ch && map.get(st.peek())>0){
                    st.pop();
                    
                }
                st.push(ch);
                map.put(ch,map.get(ch)-1);
            }
            else{
                map.put(ch,map.get(ch)-1);
            }


        }
        StringBuilder str=new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        str.reverse();
        return str.toString();
    }
}