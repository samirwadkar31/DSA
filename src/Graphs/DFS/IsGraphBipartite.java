package Graphs.DFS;

import java.util.Arrays;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] isConnected = {{1,2,3},{0,2},{0,1,3},{0,2}};

        System.out.println("Is Graph Bipartite: " + isBipartite(isConnected));
    }

    public static boolean isBipartite(int[][] graph) {

        int[] color= new int[graph.length];
        Arrays.fill(color, -1);
        //red=1
        //yellow=0

        for(int u=0; u<graph.length; u++){
            if(color[u]==-1 && !dfs(graph, color, u, 1)){
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int[][] graph, int[] color, int u, int currColor){

        color[u]=currColor;

        for(int v=0; v<graph[u].length; v++){

            if(color[u]==color[graph[u][v]]){
                return false;
            }

            if(color[graph[u][v]]==-1){
                int vColor;
                if(color[u]==1){
                    vColor=0;
                }else{
                    vColor=1;
                }
                if(!dfs(graph, color, graph[u][v], vColor)){
                    return false;
                }
            }

        }
        return true;
    }
}
