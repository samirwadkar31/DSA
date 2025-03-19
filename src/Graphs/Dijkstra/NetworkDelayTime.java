package Graphs.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,2},{3,4,3}};
        int n = 4, k = 2; // k is source node

        System.out.println("Minimum time to receive the signal to all the nodes: " + networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;

        for(int i = 0; i <= n; i++){

            adj.add( new ArrayList<>());
        }

        for(int[] time: times){
            adj.get(time[0]).add(new int[]{time[2], time[1]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){

            int[] temp = pq.poll();

            int t = temp[0];
            int u = temp[1];


            for(int[] v: adj.get(u)){

                if(v[0] + t < minTime[v[1]]){

                    minTime[v[1]] = v[0] + t;
                    pq.offer(new int[]{v[0] + t, v[1]});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(minTime[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, minTime[i]);

        }

        return ans;
    }
}
