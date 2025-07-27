class MedianFinder {
    PriorityQueue<Integer> max=new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> min=new PriorityQueue<>();
    public MedianFinder() {}
    public double med=0;
    public void addNum(int num) {
        
        max.add(num);

        min.add(max.poll());

        if(min.size()>max.size()){
            max.add(min.poll());
        }

        
    }
    
    public double findMedian() {
        if(max.size()==min.size()){
            int a=max.peek();
            int b=min.peek();
            med=(a+b)/2.0;
            return med;
        }
        else{
            return (double)max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


 /*TLE
 class MedianFinder {
    List<Integer> list=new ArrayList<>();
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        double med=0;
        int n=list.size();
        if(n==1) return list.get(0);
        if(n==2) return (list.get(0)+list.get(1))/2.0;
        if(n%2==0){
            int a=list.get(n/2);
            int b=list.get((n/2)-1);
            med=(a+b)/2.0;
        }
        else{
            med=list.get(list.size()/2);

        }
        return (med);
    }
}
 */