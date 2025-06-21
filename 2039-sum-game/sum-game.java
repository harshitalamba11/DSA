class Solution {
    public boolean sumGame(String num) {
        int q1=0;int q2=0;
        int sum1=0;int sum2=0;
        int n=num.length();
        for(int i=0;i<n/2;i++){
            if(num.charAt(i)=='?'){
                q1++;
            }
            else{
                sum1+=num.charAt(i)-'0';
            }
        }
        for(int i=n/2;i<n;i++){
            if(num.charAt(i)=='?'){
                q2++;
            }
            else{
                sum2+=num.charAt(i)-'0';
            }
        }
        return (sum1-sum2)*2==(q2-q1)*9?false:true;
    }
}