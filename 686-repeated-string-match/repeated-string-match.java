class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder s=new StringBuilder(a);
        int len=1;
        while(s.length()<b.length()){
            s.append(a);
            len++;
        }
        if(s.indexOf(b)>=0) return len;
        if(s.append(a).indexOf(b)>=0) return len+1;
        return -1;
    }
}