package Graphs.DFS.OnGrid;

public class FloodFill {
    public static void main(String[] args) {

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;

        int[][] res = floodFill(image, sr, sc, color);

        for(int[] fill: res){
            for(int f: fill){
                System.out.print(f);
            }
            System.out.println(" ");
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int flood= image[sr][sc];
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        dfs(image, color, flood, sr, sc, directions);

        return image;
    }


    public static void dfs(int[][] image, int color, int flood, int sr, int sc, int[][] directions){

        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=flood || image[sr][sc]==color){
            return;
        }

        image[sr][sc]= color;

        for(int[] dir: directions){
            dfs(image, color, flood, sr+dir[0], sc+dir[1], directions);
        }

    }
}
