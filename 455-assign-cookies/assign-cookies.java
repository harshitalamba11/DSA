class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        int l=0;
        int r=0;
        Arrays.sort(g);Arrays.sort(s);
        while(l<g.length && r<s.length){
            if(g[l]>s[r]){
                r++;
            }
            else if(g[l]<=s[r]){
                count++;
                l++;
                r++;
            }
            else{
                l++;
            }
        }
        return count;
    }
}