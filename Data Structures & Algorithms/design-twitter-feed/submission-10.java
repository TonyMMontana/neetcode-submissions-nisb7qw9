class Twitter {
    int time;
    Map<Integer, List<int[]>> tweets;
    Map<Integer, HashSet<Integer>> follows;

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{tweetId, time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        follows.computeIfAbsent(userId,k -> new HashSet<>()).add(userId);

        for(int followee : follows.get(userId)) {
            List<int[]> userTweets = tweets.get(followee);
            if(userTweets != null && userTweets.size() > 0) {
                int lastIndx = userTweets.size() - 1;
                int[] tweet = userTweets.get(lastIndx);
                maxHeap.offer(new int[] {tweet[0], tweet[1], followee, lastIndx-1});
            }
        }
        while(!maxHeap.isEmpty() && res.size() < 10) {
            int[] cur = maxHeap.poll();
            res.add(cur[0]);
            
            int followee = cur[2];
            int idx = cur[3];

            if(idx >= 0) {
                int[] tweet = tweets.get(followee).get(idx);
                maxHeap.offer(new int[] {tweet[0], tweet[1], followee, idx-1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
