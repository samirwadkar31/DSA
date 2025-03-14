package Graphs.BFS.MultiSourceBFS;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };

        wallsAndGates(rooms);

        for(int[] room: rooms){
            for(int r: room){
                System.out.print(r + " ");
            }
            System.out.println();
        }

    }

    public static void wallsAndGates(int[][] rooms) {

        int n= rooms.length;
        int m= rooms[0].length;
        Queue<int[]> queue= new LinkedList<>();
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(rooms[i][j]==0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cell= queue.poll();
           

            for(int[] dir: directions){
                int i = dir[0] + cell[0];
                int j = dir[1] + cell[1];

                if(i<0 || i>=rooms.length || j<0 || j>=rooms[0].length || rooms[i][j] != Integer.MAX_VALUE){
                    continue;
                }

                rooms[i][j]=rooms[cell[0]][cell[1]]+1;
                queue.offer(new int[]{i, j});
                
            }
        }

    }
}
