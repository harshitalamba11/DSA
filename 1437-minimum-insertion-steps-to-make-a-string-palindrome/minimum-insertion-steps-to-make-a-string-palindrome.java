class Solution {
    public int recur(String s,Integer[][] dp,int i,int j){
        if(i>=j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=recur(s,dp,i+1,j-1);
        }
        else{
            dp[i][j]=1+Math.min(recur(s,dp,i+1,j),recur(s,dp,i,j-1));
        }
        return dp[i][j];
    }
    public int minInsertions(String s) {
        //approach -2 not better than  down waali
        Integer[][] dp=new Integer[s.length()+1][s.length()+1];
        return recur(s,dp,0,s.length()-1);

        // int[] prev=new int[s.length()+1];
        // int[] curr=new int[s.length()+1];
        // StringBuilder str=new StringBuilder(s);
        // str.reverse();
        // for(int i=1;i<=s.length();i++){
        //     for(int j=1;j<=s.length();j++){
        //         if(s.charAt(i-1)==str.charAt(j-1)){
        //             curr[j]=1+prev[j-1];
        //         }
        //         else{
        //             curr[j]=Math.max(prev[j],curr[j-1]);
        //         }
        //     }
        //     int temp[]=prev;
        //     prev=curr;
        //     curr=temp;
        // }
        // return s.length()-prev[s.length()];
    }
}