class Solution {
    public boolean rotateString(String s, String goal) {
        //method 1
        /*
        if(s.length()!=goal.length()) return false;
        StringBuilder res=new StringBuilder(s);
        res.append(s);
        return res.indexOf(goal)>=0;
        */

        //method-2
        if(s.length()!=goal.length()) return false;
        for(int i=0;i<s.length();i++){
            // String res=n////
            if((s.substring(i)+s.substring(0,i)).equals(goal)){
                return true;
            }

        }
        return false;
    }
}