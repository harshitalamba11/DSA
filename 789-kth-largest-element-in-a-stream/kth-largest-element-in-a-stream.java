class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while(pq.size()>k){
            pq.poll();
        }
    }
    
    public int add(int val) {
        
        pq.add(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}



/*
class KthLargest {
    public int k;
    List<Integer> list=new ArrayList<>();
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size()-k);
    }
}
*/




/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */