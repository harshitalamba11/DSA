class Solution {
    public int findnext(int[][] list,int idx){
        for(int i=idx+1;i<list.length;i++){

            if(list[i][0]>=list[idx][1]){
                return i;
            }
        }
        return -1;
    }
    public int recur(int[][] list,int idx,Map<Integer,Integer> map){
        if(idx==list.length) return 0;
        if(map.containsKey(idx)) return map.get(idx);
        int next=findnext(list,idx);
        int take=list[idx][2]+(next==-1?0:recur(list,next,map));
        int nottake=recur(list,idx+1,map);
        map.put(idx,Math.max(take,nottake));
        return Math.max(take,nottake);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] list=new int[startTime.length][3];
        for(int i=0;i<startTime.length;i++){
            list[i]=new int[]{startTime[i],endTime[i],profit[i]};
        }
        Arrays.sort(list,(a,b)->a[0]-b[0]);
        Map<Integer,Integer> map=new HashMap<>();
        return recur(list,0,map);
    }
}





// class Solution {
//     public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//         int[][] jobs = new int[startTime.length][3];
//         for (int i = 0; i < startTime.length; i++) {
//             jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
//         }
//         Arrays.sort(jobs,(a,b)->a[0]-b[0]);
//         Map<Integer,Integer> map=new HashMap<>();
//         return recur(map,jobs,0);
//     }
//     public int findnext(int idx,int[][] jobs){
//         for(int next=idx+1;next<jobs.length;next++){
//             if(jobs[next][0]>=jobs[idx][1])return next;
//         }
//         return -1;
//     }
//     public int recur(Map<Integer,Integer> map,int[][] jobs,int idx){
//         if(idx==jobs.length) return 0;
//         if(map.containsKey(idx)) return map.get(idx); 
//         int next=findnext(idx,jobs);
//         int take=jobs[idx][2]+(next==-1?0:recur(map,jobs,next));
//         int nottake=recur(map,jobs,idx+1);
//         map.put(idx,Math.max(take,nottake));
//         return Math.max(take,nottake);
//     }
// }