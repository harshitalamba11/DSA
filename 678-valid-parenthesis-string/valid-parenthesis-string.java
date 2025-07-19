class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st=new Stack<>();
        Stack<Integer> s_=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(i);
            }
            else if(ch=='*'){
                s_.push(i);
            }
            
            else if(ch==')'){
                if(!st.isEmpty()){
                    st.pop();
                }
                else if(!s_.isEmpty() && s_.peek()<i){
                    s_.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!st.isEmpty()){
            if(!s_.isEmpty()){
                if(st.peek()<s_.peek())
                st.pop();
                s_.pop();
            }
            else{
                break;
            }
        }
        return st.isEmpty();
    }
}











// class Solution {
//     public boolean checkValidString(String s) {
//         boolean dp[][]=new boolean[s.length()+1][s.length()+1];
//         dp[s.length()][0] = true;
//         for(int i=s.length()-1;i>=0;i--){
//             for(int open=0;open<=s.length();open++){
//                  boolean isValid = false;

//                 if(open+1 <= s.length() && s.charAt(i)=='('){
//                     isValid|=dp[i+1][open+1];
//                 }
//                 else if(s.charAt(i)=='*'){
//                     if(open+1 <= s.length())
//                     isValid|=dp[i+1][open+1];
//                     isValid|=dp[i+1][open];
//                     if(open>0)isValid|=dp[i+1][open-1];
//                 }
//                 else if(open>0){
//                     isValid|=dp[i+1][open-1];
//                 }
//                 dp[i][open]=isValid;
//             }
//         }
//         return dp[0][0];
//     }
// }







// this is the dp->memoization approach
/*
class Solution {
    public boolean recur(String s, int idx, int open, int[][] dp) {
        if (open < 0) return false;  // more closing brackets than opening
        if (idx == s.length()) return open == 0;
        if (dp[idx][open] != -1) return dp[idx][open] == 1;

        boolean isValid = false;

        if (s.charAt(idx) == '(') {
            isValid |= recur(s, idx + 1, open + 1, dp);
        } else if (s.charAt(idx) == '*') {
            isValid |= recur(s, idx + 1, open + 1, dp); // treat * as '('
            isValid |= recur(s, idx + 1, open, dp);     // treat * as ''
            isValid |= recur(s, idx + 1, open - 1, dp); // treat * as ')'
        } else if (s.charAt(idx) == ')') {
            isValid |= recur(s, idx + 1, open - 1, dp);
        }

        dp[idx][open] = isValid ? 1 : 0;
        return isValid;
    }

    public boolean checkValidString(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur(s, 0, 0, dp);
    }
}

*/