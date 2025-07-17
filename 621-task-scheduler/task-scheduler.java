class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int res=0;
        int max=0;
        int l=map.size();
        for (int freq : map.values()) {
            max = Math.max(max, freq);
        }
        int count=0;
        for (int freq : map.values()) {
            if (freq == max) {
                count++;
            }
        }
        res=(max-1)*(n+1);
        res+=count;
        return Math.max(res,tasks.length);
    }
}