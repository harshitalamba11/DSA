class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()+1][p.length()+1];
        return recur(s,p,0,0,dp);
    }
    public boolean recur(String s,String p,int i,int j,Boolean[][] dp){
        if(i==s.length() && j==p.length()) return dp[i][j]=true;
        if(j==p.length()) return dp[i][j]=false;

        if(dp[i][j]!=null) return dp[i][j];

        //if string finish
        if(i==s.length()){
            while(j!=p.length() && p.charAt(j)=='*'){
                j++;
            }
            return dp[i][j]=(j==p.length()?true:false);
        }

        //if string finish nhi hua
        //pattern keh paas ? hai
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]=recur(s,p,i+1,j+1,dp);
        }
        
        //pattern keh paas * hai
        if(p.charAt(j)=='*'){
            return dp[i][j]=(i<s.length() && recur(s,p,i+1,j,dp))||(j<p.length() && recur(s,p,i,j+1,dp));
        }
        return dp[i][j]=false;
    }
}