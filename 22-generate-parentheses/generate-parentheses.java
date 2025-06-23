class Solution {
    public void helper(List<String> list,int n,int open,int close,String str){
        if(str.length()==n*2){
            if(open==n && close==n)
            list.add(str);
            return;
        }
        if(open<n)
        helper(list,n,open+1,close,str+"(");
        if(open>close)
        helper(list,n,open,close+1,str+")");
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        helper(list,n,0,0,"");
        return list;
    }
}