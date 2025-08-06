class Solution {
    public int recur(String word1,String word2,int i,int j,Integer[][] dp){
        if(j==word2.length()) return word1.length()-i;
        if(i==word1.length()) return word2.length()-j;
        if(dp[i][j]!=null) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=recur(word1,word2,i+1,j+1,dp);
        }
        else{
            int insert=recur(word1,word2,i,j+1,dp);
            int delete=recur(word1,word2,i+1,j,dp);
            int replace=recur(word1,word2,i+1,j+1,dp);
            return dp[i][j]=1+Math.min(delete,Math.min(insert,replace));
        }
    }
    public int minDistance(String word1, String word2) {
        Integer[][] dp=new Integer[word1.length()+1][word2.length()+1];
        return recur(word1,word2,0,0,dp);
    }
}