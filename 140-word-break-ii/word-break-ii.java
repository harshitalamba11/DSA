class Solution {
    public List<String> helper(String s,List<String> wordDict,int idx){
        List<String> res=new ArrayList<>();
        if(idx==s.length()){
            res.add("");
            return res;
        }
        for(int i=idx+1;i<=s.length();i++){
            String prefix=s.substring(idx,i);
            if(wordDict.contains(prefix)){
                List<String> suffixs=helper(s,wordDict,i);
                for(String suffix:suffixs){
                    res.add(prefix+(suffix.equals("")?"":" ")+suffix);
                }
            }
        }
        return res;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s,wordDict,0);
    }
}