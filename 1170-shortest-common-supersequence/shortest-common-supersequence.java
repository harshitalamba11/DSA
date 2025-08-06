class Solution {
    public String shortestCommonSupersequence(String s1, String s2){
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

        StringBuilder s=new StringBuilder();
        int i=s1.length();
        int j=s2.length();
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                s.append(s1.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                s.append(s1.charAt(i-1));
                i--;
            }
            else{
                s.append(s2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            s.append(s1.charAt(i-1));
            i--;
        }
        while(j>0){
            s.append(s2.charAt(j-1));
            j--;
        }
        return s.reverse().toString();
    }










        /* memory limit exceeded
        if (i == s1.length()) return s2.substring(j); // add remaining from s2
        if (j == s2.length()) return s1.substring(i); // add remaining from s1
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j]=s1.charAt(i)+recur(s1,s2,i+1,j+1,dp);
        }
        else{
            String option1=s1.charAt(i)+recur(s1,s2,i+1,j,dp);
            String option2=s2.charAt(j)+recur(s1,s2,i,j+1,dp);
            if(option1.length()>option2.length()){
                dp[i][j]=option2; //minimum
            }
            else{
                dp[i][j]=option1;
            }
        }
        return dp[i][j];
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        String[][] dp=new String[str1.length()+1][str2.length()];
        return recur(str1,str2,0,0,dp);
    }
    */
}