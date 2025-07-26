/*
class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a); //max-heap
        //step-2 fill the array elements in the heap and maintain the sum
        int sum=0;
        for(int i=0;i<target.length;i++){
            sum+=target[i];
            pq.add(target[i]);
        }

        //this can be the Tle  
        while(pq.peek()!=1){
            int maxele=pq.poll();
            int rem=sum-maxele;
            if(rem>=maxele || rem<=0){
                return false;
            }
            int ele=maxele-rem;
            sum-=maxele;
            pq.add(ele);
            sum+=ele;

        }
        return true;
    }
}
*/
class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a); //max-heap
        //step-2 fill the array elements in the heap and maintain the sum
        int sum=0;
        for(int i=0;i<target.length;i++){
            sum+=target[i];
            pq.add(target[i]);
        }

        //this can be the Tle so to improve line added is mod wali element=maxele%rem + test case need to understand
        // the rem case logic is that example [1,1,0] aaya toh hmara [1,1,1] to  kabhi bna gga hi nhi but [1,0] hua toh sum 1 hai means we can say ki iske previous step meh yeh [1,1] tha then [1,0] hua means [1,1] toh bna hi na....:)
        while(pq.peek()!=1){
            int maxele=pq.poll();
            int rem=sum-maxele;
            if(rem>=maxele || rem<=0){
                return false;
            }
            // int ele=maxele-rem;
            int ele=maxele%rem;
            if(ele<=0 && rem!=1) return false;
            sum-=maxele;
            pq.add(ele);
            sum+=ele;

        }
        return true;
    }
}