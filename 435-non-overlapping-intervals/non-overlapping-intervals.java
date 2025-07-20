class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            // if(a[0]==b[0]) return a[1]-b[1];
            return a[1]-b[1];
        });
        int c=0;
        int[] temp=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<temp[1]){
                c++;
            }
            else{
                temp=intervals[i];
            }
        }
        return c;
    }
}