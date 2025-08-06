class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)) return 0;
        int[] prev=new int[word2.length()+1];
        int[] curr=new int[word2.length()+1];  //dono ko 2nd string length hi deni hai
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
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
        int lcs=prev[word2.length()];
        return word1.length()+word2.length()-2*lcs;
    }
}