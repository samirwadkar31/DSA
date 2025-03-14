package Graphs.DFS;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println("Total no of provinces: " + findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {

        int count=0;
        boolean[] visited = new boolean[isConnected.length];

        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }



    public static void dfs(int[][] isConnected, int i, boolean[] visited){

        visited[i]= true;

        for(int j=0; j<isConnected[0].length; j++){

            if(isConnected[i][j]==1 && !visited[j]){
                dfs(isConnected, j, visited);
            }
        }


    }
}
