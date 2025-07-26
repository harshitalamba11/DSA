class Tuple{
    int data,idx;
    Tuple(int data,int idx){
        this.idx=idx;
        this.data=data;
    }
}
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] res=new int[arr.length];
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.data-b.data);
        for(int i=0;i<arr.length;i++){
            pq.add(new Tuple(arr[i],i));
        }
        int idx=1;
        int min=Integer.MIN_VALUE;
        while(!pq.isEmpty()){

            Tuple temp=pq.poll();
            
            if(min!=temp.data)
            res[temp.idx]=idx++;
            else {res[temp.idx]=--idx;
            idx++;}
            min=temp.data;
        }
        return res;
    }
}