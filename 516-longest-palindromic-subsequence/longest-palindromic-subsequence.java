class Solution {
    public int longestPalindromeSubseq(String s) {
        //with space 0(n)
        String s1=s;
        StringBuilder s2=new StringBuilder(s);
        s2.reverse();
        int[] prev=new int[s1.length()+1];
        int[] curr=new int[s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[s1.length()];
    }
}


/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1=s;
        StringBuilder s2=new StringBuilder(s);
        s2.reverse();
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}*/