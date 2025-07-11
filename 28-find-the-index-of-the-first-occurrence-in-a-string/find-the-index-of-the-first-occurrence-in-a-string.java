class Solution {
    public int strStr(String s1, String s2) {
        if (s2.isEmpty()) return 0;
        int[] lps=new int[s2.length()];
        lps[0]=0;
        int len=0;
        int i=1;
        while(i<s2.length()){
            if(s2.charAt(i)==s2.charAt(len)){
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

        i=0;
        int j=0;
        while(i<s1.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
                if(j==s2.length()) return i-j;
            }
            else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return -1;
    }
}






// class Solution {
//     public int strStr(String s1, String s2) {
        // method-1
        // return s1.indexOf(s2);

        // method-2
        // int j=s2.length();
        // for(int i=0;i<s1.length() && j<=s1.length();i++){
        //     if(s1.substring(i,j).equals(s2)){
        //         return i;
        //     }
        //     j++;
        // }
        // return -1;


        //method-3
        //brute-force
        // int m=s1.length();
        // int n=s2.length();
        
        // for(int i=0;i<=m-n;i++){
        //     int j=0;
        //     while(j<s2.length() && s1.charAt(i+j)==s2.charAt(j)){
        //         j++;
        //     }
        //     if(j==n) return i;
        // }
        // return -1;


        //method-4
        // public int strStr(String s1, String s2) {
//         if (s2.isEmpty()) return 0;

//         // Step 1: Build LPS array
//         int[] lps = new int[s2.length()];
//         int len = 0;
//         int i = 1;

//         while (i < s2.length()) {
//             if (s2.charAt(i) == s2.charAt(len)) {
//                 len++;
//                 lps[i] = len;
//                 i++;
//             } else {
//                 if (len != 0) {
//                     len = lps[len - 1];
//                 } else {
//                     lps[i] = 0;
//                     i++;
//                 }
//             }
//         }

//         // Step 2: Pattern Search
//         int k = 0; // for s2
//         int l = 0; // for s1

//         while (l < s1.length()) {
//             if (s1.charAt(l) == s2.charAt(k)) {
//                 l++;
//                 k++;
//                 if (k == s2.length()) return l - k;
//             } else {
//                 if (k != 0) {
//                     k = lps[k - 1];
//                 } else {
//                     l++;
//                 }
//             }
//         }

//         return -1;
//     }
// }