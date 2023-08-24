package heap;

import java.util.*;

public class DesignTwitter355 {

    class Tweet{
        int tweetId;
        int time;
        public Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time=time;
        }
    }

    Map<Integer, List<Tweet>> userTweetMap;
    Map<Integer, Set<Integer>> followersMap;
    int time,k;

    public DesignTwitter355() {
        userTweetMap = new HashMap<>();
        followersMap = new HashMap<>();
        time=0;
        k=10;
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        if (!followersMap.containsKey(userId))
            followersMap.computeIfAbsent(userId, e-> new HashSet<>()).add(userId);
        userTweetMap.computeIfAbsent(userId, t->new ArrayList<>()).add(new Tweet(tweetId, -time));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!followersMap.containsKey(userId))
            followersMap.computeIfAbsent(userId, e-> new HashSet<>()).add(userId);
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(Comparator.comparingInt(t->t.time));
        List<Integer> tweets = new ArrayList<>();
        PriorityQueue<int[]> latestTweet = new PriorityQueue<>(Comparator.comparing(a->a[0]));
        for(int user: followersMap.getOrDefault(userId, new HashSet<>())){

            if (!userTweetMap.containsKey(user) || userTweetMap.get(user).isEmpty())
                continue;
            Tweet lastTweet =userTweetMap.get(user).get(userTweetMap.get(user).size() -1);
            latestTweet.offer(new int[]{lastTweet.time, lastTweet.tweetId, user, userTweetMap.get(user).size()-1});
        }

        while (!latestTweet.isEmpty() &&   tweets.size() < k){
            int[] mostRecent = latestTweet.poll();
            tweets.add(mostRecent[1]);
            if (mostRecent[3] > 0 ){
                Tweet t = userTweetMap.get(mostRecent[2]).get(--mostRecent[3]);
                latestTweet.offer(new int[]{t.time, t.tweetId, mostRecent[2], mostRecent[3]});
            }
        }
        return tweets;
    }

    public void follow(int followerId, int followeeId) {
        if (!followersMap.containsKey(followerId)){
            followersMap.put(followerId, new HashSet<>());
            followersMap.get(followerId).add(followerId);
        }
        followersMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followerId, e -> new HashSet<>()).remove(followeeId);
    }

    public static void main(String[] args) {
        DesignTwitter355 prog = new DesignTwitter355();
        prog.postTweet(1,5);
        prog.follow(1,2);
        prog.follow(2,1);
        System.out.println(prog.getNewsFeed(2));
        prog.postTweet(2,6);
        System.out.println(prog.getNewsFeed(1));
        System.out.println(prog.getNewsFeed(2));
        prog.unfollow(2,1);
        System.out.println(prog.getNewsFeed(1));
        System.out.println(prog.getNewsFeed(2));
        prog.unfollow(1,2);
        System.out.println(prog.getNewsFeed(1));
        System.out.println(prog.getNewsFeed(2));
    }

}
