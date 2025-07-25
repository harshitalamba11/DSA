class Tuple{
    int data,row,col;
    Tuple(int data,int row,int col){
        this.data=data;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.data-b.data);
        int min=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            pq.add(new Tuple(nums.get(i).get(0),i,0));
            max=Math.max(max,nums.get(i).get(0));
        }
        min=pq.peek().data;
        int start=min;
        int end=max;
        while(true){
            Tuple temp=pq.poll();
            int row=temp.row;
            int col=temp.col;
            if(end-start<max-min){
                min=start;
                max=end;
            }
            if(col+1<nums.get(row).size()){
                pq.add(new Tuple(nums.get(row).get(col+1),row,col+1));
                end=Math.max(end,nums.get(row).get(col+1));
                start=pq.peek().data;
            }
            else
            break;
        }
        int[] res=new int[]{min,max};
        return res;
    }
}