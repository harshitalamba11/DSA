class Solution {
    public int[] getOrder(int[][] tasks) {

        //step-1 sort and all...
        int[][] list=new int[tasks.length][3];
        int[] res=new int[tasks.length];
        for(int i=0;i<list.length;i++){
            list[i]=new int[]{tasks[i][0],tasks[i][1],i};
        }
        Arrays.sort(list,(a,b)->a[0]-b[0]);


        //step-2 
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return a[2]-b[2];
            return a[1]-b[1];
        });
        int timer=list[0][0];
        int i=0;
        int idx=0;
        while(!pq.isEmpty() || i<list.length){
            while(i<list.length && list[i][0]<=timer){
                pq.offer(new int[]{list[i][0], list[i][1], list[i][2]});
                i++;
            }
            if(pq.isEmpty()){
                timer=list[i][0];
            }
            else{
                int[] task=pq.poll();
                res[idx++]=task[2];
                timer+=task[1];
            }
        }
        
        return res;

    }
}