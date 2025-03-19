package Graphs.BFS.OnGrid;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0}, {1,1,0}, {1,1,0}};
        System.out.println("Shortest distance from Source(0,0) to Target(n-1, n-1) is : " + shortestPathBinaryMatrix(grid));

    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if(n == 1 && grid[0][0] == 0) return 1;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        int[][] directions = {{1,1}, {-1,1}, {1,-1}, {-1,-1}, {-1,0}, {1,0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0,0});
        grid[0][0] = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int k = 0; k < size; k++){
                int[] temp = queue.poll();
                int i = temp[0];
                int j = temp[1];

                for(int[] dir: directions){

                    int x = i + dir[0];
                    int y = j + dir[1];

                    if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] != 0) continue;

                    grid[x][y] = 1 + grid[i][j];

                    queue.offer(new int[]{x, y});

                    if(x == n-1 && y == n-1) return grid[x][y];
                }
            }
        }

        if(grid[n-1][n-1] == 0) return -1;

        return grid[n-1][n-1];
    }
}
