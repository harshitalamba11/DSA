class Solution {
    public int longestStrChain(String[] arr) {
        //step-1 :sorting the array
        Arrays.sort(arr, (a, b) -> Integer.compare(a.length(), b.length()));
        
        //step-2
        int max=0;
        int[] dp=new int[arr.length];
        Arrays.fill(dp,1);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i].length()==arr[j].length()+1 && check(arr[j],arr[i])){   //for check j is smaller one and i wala is larger one..
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public boolean check(String str1,String str2){
        int c=1;
        int i=0;
        int j=0;
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i)==str2.charAt(j)){
                i++;j++;
            }
            else{
                if(c==0) return false;
                c--;
                j++;
            }
        }
        return true;
    }
}