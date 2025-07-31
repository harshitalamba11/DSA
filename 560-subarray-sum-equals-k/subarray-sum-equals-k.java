class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] res=new int[nums.length];
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;int c=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k) c++;
            if(map.containsKey(sum-k)){
                c+=map.get(sum-k);

            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;
    }
}