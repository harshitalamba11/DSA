class Solution {
    public String longestPrefix(String s) {
        
        // String rev=new StringBuilder(s).reverse().toString();
        // String temp=s+"-"+rev;
        int[] lps=new int[s.length()];
        lps[0]=0;
        int len=0;
        for(int i=1;i<s.length();){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){ 
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        int largestprefix=lps[s.length()-1];
        String t=s.substring(0,largestprefix);
        return  t;
    }
}