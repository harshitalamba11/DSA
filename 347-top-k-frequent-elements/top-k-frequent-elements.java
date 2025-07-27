class Tuple{
    int data;
    int next;
    Tuple(int data,int next){
        this.data=data;this.next=next;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->b.next-a.next);
        for(int ele:map.keySet()){
            pq.add(new Tuple(ele,map.get(ele)));
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll().data;
        }
        return res;
    }
}