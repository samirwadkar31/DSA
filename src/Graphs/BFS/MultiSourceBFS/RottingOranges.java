package Graphs.BFS.MultiSourceBFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{2,1,0},{0,1,1}};
        System.out.println("Time in minutes to make all oranges rotten: " + orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int minute = 0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();

                for(int[] dir: directions){
                    int i = dir[0] + cell[0];
                    int j = dir[1] + cell[1];

                    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0 || grid[i][j] == 2){
                        continue;
                    }

                    grid[i][j] = 2;
                    queue.offer(new int[]{i, j});
                    freshCount--;
                    rotted = true;

                }
            }

            if (rotted) minute++;
        }

        return freshCount == 0 ? minute : -1;
    }
}
