class Solution {
    public class Pair{
        int n,u;
        Pair(int n,int u){
            this.n=n;
            this.u=u;
        }
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.u-a.u);
        for(int i=0;i<boxTypes.length;i++){
            pq.add(new Pair(boxTypes[i][0],boxTypes[i][1]));
        }

        int maxamt=0;
        while(!pq.isEmpty() && truckSize!=0){
            Pair curr=pq.poll();
            int unit=curr.u;
            int num=curr.n;
            if(num<truckSize){
                maxamt+=num*unit;
                truckSize-=num;
            }
            else{
                maxamt+=truckSize*unit;
                truckSize=0;
            }
        }
        return maxamt;
    }
}