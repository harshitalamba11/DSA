class Solution {
    public long pickGifts(int[] gifts, int k) {
        long profit=0;
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<gifts.length;i++){
            p.add(gifts[i]);
        }
        while(k>0 && !p.isEmpty()){
            int a=p.poll();
            p.add((int)Math.floor(Math.sqrt(a)));
            k--;
        }
        while(!p.isEmpty()){
            profit+=p.poll();
        }
        return profit;
    }
}