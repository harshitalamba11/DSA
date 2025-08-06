class Solution {
    public int recur(String s,String t,int i,int j,Integer[][] dp){
        if (j == t.length()) return 1;
        if (i == s.length()) return 0; 
        if (dp[i][j] != null) return dp[i][j];
        int c=0;
        if(s.charAt(i)==t.charAt(j)){
            c+=recur(s,t,i+1,j+1,dp);
        }
        c+=recur(s,t,i+1,j,dp);
        return dp[i][j] = c;

    }
    public int numDistinct(String s, String t) {
        Integer[][] dp=new Integer[s.length()+1][t.length()+1];
        return recur(s,t,0,0,dp);
    }
}











/*
class Solution {
    public int recur(String s,String t,int idx,String str){
        if(str.equals(t)) return 1;
        if(idx>=s.length()) return 0;
        return recur(s,t,idx+1,str+s.charAt(idx))+recur(s,t,idx+1,str);
    }
    public int numDistinct(String s, String t) {
        return recur(s,t,0,"");


    }
}
*/