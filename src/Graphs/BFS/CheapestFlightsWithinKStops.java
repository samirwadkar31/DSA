package Graphs.BFS;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 4, src = 0,  dst = 3,  k = 1;
        int[][] flights = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        System.out.println("Cheapest flight price within K stops : " + findCheapestPrice(n, flights, src, dst, k));

    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] minCost = new int[n];

        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[src] = 0;

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight: flights){
            adj.get(flight[0]).add(new int[]{flight[2],flight[1]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, src});
        int stops = 0;

        while(!queue.isEmpty() && stops <= k){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                int[] temp = queue.poll();
                int cost = temp[0];
                int u = temp[1];

                for(int[] v: adj.get(u)){

                    if(v[0] + cost < minCost[v[1]]){
                        minCost[v[1]] = v[0] + cost;
                        queue.offer(new int[]{v[0] + cost, v[1]});
                    }
                }
            }

            stops++;
        }


        return minCost[dst] == Integer.MAX_VALUE ? -1: minCost[dst];
    }
}
