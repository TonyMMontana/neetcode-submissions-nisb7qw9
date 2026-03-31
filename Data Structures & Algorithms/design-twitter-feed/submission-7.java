class Twitter {
    AtomicInteger time;
    Map<Integer, List<Integer>> users;
    PriorityQueue<int[]> tweets;

    public Twitter() {
        users = new HashMap<>();
        tweets = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        time = new AtomicInteger(0);
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{time.getAndIncrement(), userId, tweetId});
    }
    
public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new ArrayList<>();
    List<Integer> subscriptionList = users.getOrDefault(userId, new ArrayList<>());
    List<int[]> temp = new ArrayList<>();
    
    while (!tweets.isEmpty()) {  // ← poll everything
        int[] arr = tweets.poll();
        temp.add(arr);
        if (arr[1] == userId || subscriptionList.contains(arr[1])) {
            if (res.size() < 10) {  // ← cap only the result list
                res.add(arr[2]);
            }
        }
    }
    
    tweets.addAll(temp);
    return res;
}
    
public void follow(int followerId, int followeeId) {
    List<Integer> subscriptionList = users.getOrDefault(followerId, new ArrayList<>());
    if (!subscriptionList.contains(followeeId)) {  // ← prevent duplicate
        subscriptionList.add(followeeId);
    }
    users.put(followerId, subscriptionList);
}
    
    public void unfollow(int followerId, int followeeId) {
        List<Integer> subsciptionList = users.getOrDefault(followerId, new ArrayList<>());
        subsciptionList.remove(Integer.valueOf(followeeId));
        users.put(followerId, subsciptionList);
    }
}
