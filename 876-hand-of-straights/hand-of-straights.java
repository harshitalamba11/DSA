class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        while(!map.isEmpty()){
            int start = map.firstKey();
            for(int i=0;i<groupSize;i++){
                int cur=i+start;
                if(!map.containsKey(cur)) return false;
                map.put(cur,map.get(cur)-1);
                if(map.get(cur)==0) map.remove(cur);
            }
        }
        return true;
    }
}