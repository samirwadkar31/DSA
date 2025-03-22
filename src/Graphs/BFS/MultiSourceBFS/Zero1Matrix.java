package Graphs.BFS.MultiSourceBFS;

import java.util.LinkedList;
import java.util.Queue;

public class Zero1Matrix {
    public static void main(String[] args) {
        int[][] mat = {
                {0,0,1,0},
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,0}};

        int[][] ans = updateMatrix(mat);

        for(int[] a: ans){
            for(int num: a){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }


        while(!queue.isEmpty()){

            int[] temp = queue.poll();

            int i = temp[0];
            int j = temp[1];

            for(int[] dir: directions){
                int x = i + dir[0];
                int y = j + dir[1];

                if(x < 0 || y < 0 || x >= n || y >= m || mat[x][y] != -1) continue;

                mat[x][y] = mat[i][j] + 1;
                queue.offer(new int[]{x,y});

            }
        }

        return mat;
    }
}
