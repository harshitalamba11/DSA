class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        StringBuilder res=new StringBuilder();
        int c=1;
        String say=countAndSay(n-1);
        for(int i=1;i<say.length();i++){
            if(say.charAt(i)==say.charAt(i-1)){
                c++;
            }
            else{
                res.append(c).append(say.charAt(i-1));
                c=1;
            }
        }
        res.append(c).append(say.charAt(say.length() - 1));
        return res.toString();
    }
}