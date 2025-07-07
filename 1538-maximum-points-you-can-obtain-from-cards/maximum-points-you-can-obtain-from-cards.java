class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int max=sum;
        int left=k-1;
        int right=cardPoints.length-1;
        for(int j=0;j<k;j++){
            sum-=cardPoints[left];
            left--;
            sum+=cardPoints[right];
            right--;
            max=Math.max(max,sum);
        }
        return max;
    }
}