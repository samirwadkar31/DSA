package Graphs.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        // [[1,3],[3,0,1],[2],[0]]

        System.out.println("Is it possible to visit all rooms: " + canVisitAllRooms(rooms));

    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        dfs(rooms, visited, 0);

        for(int i=0; i<visited.length; i++){
            if(visited[i]==false) return false;
        }

        return true;
    }

    public static void dfs(List<List<Integer>> rooms, boolean[] visited, int u){

        visited[u]= true;

        for(int v: rooms.get(u)){
            if(!visited[v]){
                dfs(rooms, visited, v);
            }
        }
    }
}
