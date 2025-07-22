class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            p.add(stones[i]);
        }
        while(p.size()>1){
            int a=p.poll();
            int b=p.poll();
            p.add(a-b);
        }
        return p.poll();
    }
}