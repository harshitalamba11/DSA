class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        for(char i:map.keySet()){
            max=Math.max(max,map.get(i));
        }
        int sum=(max-1)*(n+1);
        for(char i:map.keySet()){
            if(map.get(i)==max){
                sum+=1;
            }
        }
        return Math.max(sum, tasks.length);





        // Map<Character,Integer> map=new HashMap<>();
        // for (char task : tasks) {
        //     map.put(task, map.getOrDefault(task, 0) + 1);
        // }
        // int res=0;
        // int max=0;
        // int l=map.size();
        // for (int freq : map.values()) {
        //     max = Math.max(max, freq);
        // }
        // int count=0;
        // for (int freq : map.values()) {
        //     if (freq == max) {
        //         count++;
        //     }
        // }
        // res=(max-1)*(n+1);
        // res+=count;
        // return Math.max(res,tasks.length);
    }
}