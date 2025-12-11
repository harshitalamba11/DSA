class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        int m=str1.length();
        int n=str2.length();
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        StringBuilder s=new StringBuilder();
        int i=m;int j=n;
        while(i>0 && j>0){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    s.append(str1.charAt(i-1));i--;j--;
                }
                else if(dp[i-1][j]>dp[i][j-1]){
                    s.append(str1.charAt(i-1));
                    i--;
                }
                else{
                    s.append(str2.charAt(j-1));
                    j--;
                }
            
        }
        while(i>0){
            s.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            s.append(str2.charAt(j-1));
            j--;
        }
        return s.reverse().toString();
    }
}