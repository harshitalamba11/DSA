class Twitter {
    private static int time = 0;

    private class Tweet {
        int id;
        int timestamp;
        Tweet(int id, int time) {
            this.id = id;
            this.timestamp = time;
        }
    }

    Map<Integer, List<Tweet>> tweets = new HashMap<>();
    Map<Integer, Set<Integer>> follows = new HashMap<>();

    public Twitter() { }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);
        follows.putIfAbsent(userId, new HashSet<>());
        follows.get(userId).add(userId); // include own tweets

        for (int user : follows.get(userId)) {
            List<Tweet> userTweets = tweets.getOrDefault(user, new ArrayList<>());
            for (Tweet tweet : userTweets) {
                pq.offer(tweet);
                if (pq.size() > 10) pq.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll().id);
        Collections.reverse(res);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // can't unfollow yourself
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
