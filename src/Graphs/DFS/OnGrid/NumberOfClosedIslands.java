package Graphs.DFS.OnGrid;

public class NumberOfClosedIslands {

    static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public static void main(String[] args) {
            int[][] grid = {{1,1,1,1,1,1,1,0},
                            {1,0,0,0,0,1,1,0},
                            {1,0,1,0,1,1,1,0},
                            {1,0,0,0,0,1,0,1},
                            {1,1,1,1,1,1,1,0}};
        // combination of surrounded region and Flood fill
        System.out.println("Total number closed Island: " + closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {

        //checking if first or last row has any land
        for(int col=0; col<grid[0].length; col++){
            if(grid[0][col]==0){
                floodFill(grid, 0, col);
            }
        }
        for(int col=0; col<grid[0].length; col++){
            if(grid[grid.length-1][col]==0){
                floodFill(grid, grid.length-1, col);
            }
        }

        //checking if first or last col has any land
        for(int row=0; row<grid.length; row++){
            if(grid[row][0]==0){
                floodFill(grid, row, 0);
            }
        }
        for(int row=0; row<grid.length; row++){
            if(grid[row][grid[0].length-1]==0){
                floodFill(grid, row, grid[0].length-1);
            }
        }

        //do flood fill on lands surrounded by water and keep count
        int count=0;
        for(int i=1; i<grid.length-1; i++){
            for(int j=1; j<grid[0].length-1; j++){

                if(grid[i][j]==0){
                    count++;
                    floodFill(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void floodFill(int[][] grid, int i, int j){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==1) return;

        grid[i][j]=1;

        for(int[] dir: directions){
            floodFill(grid, i+dir[0], j+dir[1]);
        }

    }
}
