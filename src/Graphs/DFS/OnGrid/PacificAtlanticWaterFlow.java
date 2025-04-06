package Graphs.DFS.OnGrid;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}};

        List<List<Integer>> ans = pacificAtlantic(heights);

        for(List<Integer> coordinates: ans){
            System.out.print(coordinates + " ");
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();
        int[][] directions = {{-1,0}, {1,0},{0,1},{0,-1}};

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i = 0; i < m; i++){
            helper(heights, 0, i, pacific, Integer.MIN_VALUE, directions);
            helper(heights, n - 1, i, atlantic, Integer.MIN_VALUE, directions);
        }

        for(int i = 0; i < n; i++){
            helper(heights, i, 0, pacific, Integer.MIN_VALUE, directions);
            helper(heights, i, m - 1, atlantic, Integer.MIN_VALUE, directions);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);
                    res.add(new ArrayList<>(tempList));
                }
            }
        }
        return res;
    }

    public static void helper(int[][] heights, int i, int j, boolean[][] canFlow, int parent, int[][] directions){

        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || canFlow[i][j]) return;

        if(heights[i][j] < parent) return;

        canFlow[i][j] = true;

        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];

            helper(heights, x, y, canFlow, heights[i][j], directions);
        }

    }
}
