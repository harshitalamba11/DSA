class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        StringBuilder res=new StringBuilder(s);
        res.append(s);
        return res.indexOf(goal)>=0;
    }
}