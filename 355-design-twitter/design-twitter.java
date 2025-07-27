
class Tweet{
    int tweetid;
    int time=0;
    Tweet(int tweetid,int time){
        this.tweetid=tweetid;
        this.time=time;
    }
}
class Twitter {
    public int time=1;
    Map<Integer,List<Tweet>> map1=new HashMap<>();
    Map<Integer,HashSet<Integer>> map2=new HashMap<>();
    public Twitter() {}
    public void postTweet(int userId, int tweetId) {
        map1.putIfAbsent(userId,new ArrayList<>());
        map1.get(userId).add(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();

        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b)->b.time-a.time);


        pq.addAll(map1.getOrDefault(userId,new ArrayList<>()));

        HashSet<Integer> followees = map2.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followees) {
            List<Tweet> tweets = map1.getOrDefault(followeeId, new ArrayList<>());
            pq.addAll(tweets);
        }


        int k=10;
        while(k>0 && !pq.isEmpty()){
            Tweet t=pq.poll();
            res.add(t.tweetid);
            k--;
        }
        // Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        map2.putIfAbsent(followerId,new HashSet<>());
        map2.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(map2.containsKey(followerId)){
            map2.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */