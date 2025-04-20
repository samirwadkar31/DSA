package Design;

import java.util.*;

public class TwitterDesign{
    public static void main(String[] args) {


        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

    }
}

class Twitter {

    int userId;
    int tweetId;
    int followerId;
    int followeeId;
    int time;

    Map<Integer, Set<Integer>> followersMap;
    Map<Integer, List<int[]>> tweetsMap;

    PriorityQueue<int[]> pq;

    public Twitter() {
        followersMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        userId = -1;
        tweetId = -1;
        followerId = -1;
        followeeId = -1;
        time = 1;
    }

    public void postTweet(int userId, int tweetId) {

        if(!tweetsMap.containsKey(userId)){
            int[] arr = new int[2];
            arr[0] = tweetId;
            arr[1] = time;
            time++;
            List<int[]> list = new ArrayList<>();
            list.add(arr);
            tweetsMap.put(userId, new ArrayList<>(list));
        }else{
            tweetsMap.get(userId).add(new int[]{tweetId, time});
            time++;
        }

    }

    public List<Integer> getNewsFeed(int userId) {
        pq.clear();

        Set<Integer> temp = followersMap.getOrDefault(userId, new HashSet<>());
        Set<Integer> tempSet = new HashSet<>(temp);
        tempSet.add(userId);


        for(int user: tempSet){

            if(tweetsMap.containsKey(user)){

                List<int[]> tempList = tweetsMap.get(user);

                for(int[] a: tempList){

                    pq.offer(a);

                    if(pq.size() > 10){
                        pq.poll();
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!pq.isEmpty()){
            result.add(0, pq.poll()[0]);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        //1 -> 2 3 4
        //2 -> 6 5 9
        if(!followersMap.containsKey(followerId)){
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followersMap.put(followerId, set);
        }else{
            followersMap.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if(!followersMap.containsKey(followerId)){
            return;
        }else{
            followersMap.get(followerId).remove(followeeId);
        }
    }
}
