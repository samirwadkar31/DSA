package Graphs.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2},
                {3,8,2},
                {5,3,5}};

        System.out.println("Minimum efforts to reach from Source(0,0) to Destination(n-1,m-1) is : " + minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        int[][] minEfforts = new int[n][m];

        for(int[] ef: minEfforts) Arrays.fill(ef, Integer.MAX_VALUE);
        minEfforts[0][0] = 0;

        int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0,0,0});


        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int effort = temp[0];
            int i = temp[1];
            int j = temp[2];

            for(int[] dir : directions){
                int x = i + dir[0];
                int y = j + dir[1];

                if(x < 0 || y < 0 || x >= n || y >= m) continue;

                int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[i][j]));

                if(minEfforts[x][y] > newEffort){
                    minEfforts[x][y] = newEffort;
                    pq.offer(new int[]{newEffort, x, y});
                }

            }
        }

        return minEfforts[n-1][m-1];
    }
}
