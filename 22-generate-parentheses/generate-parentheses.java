class Solution {
    public boolean validbrackets(String str){
        int c=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                c++;
            }
            else{
                c--;
            }
             if (c < 0) return false;
        }
        return c==0;
    }
    public void helper(List<String> list,int n,String str){
        if(str.length()==n*2){
            if(validbrackets(str)){
            list.add(str);}
            return;
        }
        helper(list,n,str+"(");
        // str.deleteCharAt(str.length() - 1);
        helper(list,n,str+")");
        // str.deleteCharAt(str.length() - 1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        // StringBuilder str=new StringBuilder();
        helper(list,n,"");
        return list;
    }
}