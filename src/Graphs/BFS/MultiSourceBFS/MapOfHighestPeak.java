package Graphs.BFS.MultiSourceBFS;

import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {
    public static void main(String[] args) {
        int[][] isWater = {{0,0,1}, {1,0,0}, {0,0,0}};
        highestPeak(isWater);

        for(int[] ans: isWater){
            for(int num: ans){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void highestPeak(int[][] isWater) {

        int n = isWater.length;
        int m = isWater[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(isWater[i][j] == 1){
                    isWater[i][j] = 0;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }else{

                }
            }
        }

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int k = 0; k < size; k++){
                int[] temp = queue.poll();
                int i = temp[0];
                int j = temp[1];

                for(int[] dir: directions){
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) continue;

                    isWater[x][y] = 1 + isWater[i][j];
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }

            }
        }
    }
}
