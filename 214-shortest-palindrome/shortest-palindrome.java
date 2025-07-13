class Solution {
    public String shortestPalindrome(String s) {
        //method-1
        // String rev=new StringBuilder(s).reverse().toString();

        // for(int i=0;i<s.length();i++){
        //     if (s.startsWith(rev.substring(i))){
        //         return rev.substring(0,i)+s;
        //     }
        // }
        // return rev+s;



        //method-2
        //kmp


        String rev=new StringBuilder(s).reverse().toString();
        String temp=s+"-"+rev;
        int[] lps=new int[temp.length()];
        lps[0]=0;
        int len=0;
        for(int i=1;i<temp.length();){
            if(temp.charAt(i)==temp.charAt(len)){
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
        int largestprefix=lps[temp.length()-1];
        String t=rev.substring(0,s.length()-largestprefix);
        return  t+s;
    }
}