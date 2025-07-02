class Solution {
    private static final Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public void solve(List<String> res,String str,int idx,String s){
        if(idx>=str.length()){
            res.add(s);
            return;
        }
        char ch=str.charAt(idx);
        String pro_str=map.get(ch);
        for(int i=0;i<pro_str.length();i++){
            solve(res,str,idx+1,s+pro_str.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.equals("")) return res;
        solve(res,digits,0,"");
        return res;
    }
}