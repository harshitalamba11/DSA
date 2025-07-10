class Solution {
    final static int d = 256; // number of characters in the input alphabet

    public static int search(String pat, String txt, int q) {
        int i=0;
        // int q=101;
        int j=0;
        int m=pat.length();
        int n=txt.length();
        int h=1;int p=0;int t=0;
        for(i=0;i<m-1;i++){
            h=(h*d)%q;
        }
        for(i=0;i<m;i++){
            p=(p*d+pat.charAt(i))%q;
            t=(t*d+txt.charAt(i))%q;
        }
        for(i=0;i<=n-m;i++){
            if(p==t){
                for(j=0;j<m;j++){
                    if(txt.charAt(i+j)!=pat.charAt(j)) break;
                }
                if(j==m){
                    return i;
                }
            }
            if (i < n-m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                if (t < 0) t += q;
            }
        }

        return -1;
    }

    public int repeatedStringMatch(String a, String b) {
        int q = 101; // a prime number
        StringBuilder s = new StringBuilder(a);
        int count = 1;

        while (s.length() < b.length()) {
            s.append(a);
            count++;
        }

        // Try search in current string
        if (search(b, s.toString(), q) != -1) return count;

        // Try adding one more 'a'
        s.append(a);
        if (search(b, s.toString(), q) != -1) return count + 1;

        return -1;
    }
}



/*
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
*/