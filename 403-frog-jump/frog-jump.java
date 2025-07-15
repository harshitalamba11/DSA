class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for(int i=0;i<stones.length;i++){
            int curr=stones[i];
            Set<Integer> jumps=new HashSet(map.get(curr));
            for(int jump:jumps){
                int pos=jump+curr;
                if(pos==stones[stones.length-1]){
                    return true;
                }
                if(map.containsKey(pos)){
                    if(jump-1>0) map.get(pos).add(jump-1);
                    map.get(pos).add(jump);
                    map.get(pos).add(jump+1);
                }
            }
        }
        return false;
    }
}