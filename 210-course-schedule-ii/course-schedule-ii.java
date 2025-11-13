class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg=new int[ numCourses];
        Queue<Integer> q=new PriorityQueue<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indeg[prerequisites[i][0]]++;
        }
        int[] res=new int[numCourses];
        //make the map with the parameter of indegree to use further , can make the list also
        // so that is why indeg used

        //now add the 0 indeg wale num in q
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0) q.add(i);
        }

        //now start the algo
        int count=0;
        int flag=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            res[count]=curr;
            count++;
            for(int des:adj.get(curr)){
                indeg[des]--;
                if(indeg[des]==0){
                    q.add(des);
                }
            }
        }
        return (count==numCourses)?res:new int[0];
    }
}