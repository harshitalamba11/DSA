class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] all = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            all[i] = intervals[i];
        }
        all[n] = newInterval;
        Arrays.sort(all,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int[] temp=all[0];
        List<int[]> res=new ArrayList<>();
        for(int j=1;j<all.length;j++){
            if (all[j][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], all[j][1]); // merge
            } else {
                res.add(temp);
                temp = all[j];
            }
        }
        res.add(temp);
        return res.toArray(new int[res.size()][]);
    }
}