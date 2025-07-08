class Solution {
    public int helper(int[] nums,int k){
        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        int c=0;int max=0;
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            c+=right-left+1;
            // max=Math.max(c,max);
        }
        return c;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return helper(nums,k)-helper(nums,k-1);
    }
}