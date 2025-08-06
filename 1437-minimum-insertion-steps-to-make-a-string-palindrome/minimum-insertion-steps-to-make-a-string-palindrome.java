class Solution {
    public int minInsertions(String s) {
        int[] prev=new int[s.length()+1];
        int[] curr=new int[s.length()+1];
        StringBuilder str=new StringBuilder(s);
        str.reverse();
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=s.length();j++){
                if(s.charAt(i-1)==str.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            int temp[]=prev;
            prev=curr;
            curr=temp;
        }
        return s.length()-prev[s.length()];
    }
}