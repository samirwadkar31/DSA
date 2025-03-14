package Graphs.DFS.OnGrid;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};
        int sr = 1, sc = 1, color = 2;

        System.out.println("Total no of islands: " + numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count=0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j, directions);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid,int i, int j, int[][] directions){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';

        for(int[] dir: directions){
            dfs(grid, i+dir[0], j+dir[1], directions);
        }

    }
}
