package Graphs.DFS.OnGrid;

public class MaximumNumberOfFishInGrid {

    public static void main(String[] args) {
        int[][] grid = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};

        System.out.println("Max number of fish can be cached: " + findMaxFish(grid));
    }

    public static int findMaxFish(int[][] grid) {

        int maxFish=0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]!=0){
                    int fish= dfs(grid, i, j, directions);
                    maxFish= Math.max(fish, maxFish);
                }
            }
        }
        return maxFish;

    }

    public static int dfs(int[][] grid,int i, int j, int[][] directions){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }

        int fishCount= grid[i][j];
        grid[i][j]=0;

        for(int[] dir: directions){
            fishCount += dfs(grid, i+dir[0], j+dir[1], directions);
        }


        return fishCount;
    }
}
