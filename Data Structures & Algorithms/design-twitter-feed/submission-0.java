class Twitter {
    private static int timestamp = 0;

    // internal tweet class acting as LinkedList node
    private class Tweet{
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    // Internal User class keeps track of follows and their own tweet head
    private class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;

        public User(int id){
            this.id = id;
            followed = new HashSet<>();
            follow(id); // user follow themselves
            tweetHead = null;
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            // can't unfollow yourself
            if(id != this.id){
                followed.remove(id);
            }
        }

        public void post(int id){
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    private Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return res;
        }

        Set<Integer> users = userMap.get(userId).followed;

        // PriorityQueue to order tweets by most recent time (Max Heap)
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        for(int user: users){
            Tweet t = userMap.get(user).tweetHead;
            if(t != null){
                pq.add(t);
            }
        }

        int n = 0;
        // Merge the top 10 most recent tweets
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                pq.add(t.next);
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}
