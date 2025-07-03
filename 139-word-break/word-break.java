class Solution {
    public Boolean[] t=new Boolean[301];
    public boolean helper(String s,List<String> wordDict,int idx){
        int n=s.length();
        if(idx>=n) return true;
        if (t[idx] != null) return t[idx];
        for(int i=idx+1;i<=n;i++){
            String str=s.substring(idx,i);
            if(wordDict.contains(str) && helper(s,wordDict,i)){
                // true;
                return t[idx]=true;
                
            }
        }
        return t[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s,wordDict,0);
    }
}