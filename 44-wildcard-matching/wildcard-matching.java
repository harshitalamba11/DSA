class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()+1][p.length()+1];
        return recur(s,p,0,0,dp);
    }
    public boolean recur(String s,String p,int i,int j,Boolean[][] dp){
        if(i==s.length() && j==p.length()) return true;
        if(j==p.length()) return false;
        if(dp[i][j]!=null) return dp[i][j];
        if(i==s.length()){
            while(j<p.length() && p.charAt(j)=='*'){
                j++;
            }
            return j==p.length();
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]=recur(s,p,i+1,j+1,dp);
        } 
        else if(p.charAt(j)=='*'){
            return dp[i][j]=(j<p.length() && recur(s,p,i,j+1,dp) || (i<s.length() && recur(s,p,i+1,j,dp)));
        }
        return false;
    }
}