package Graphs.DFS;

import java.util.*;

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,3}, {3,4}, {4,2}};

        System.out.println("Is cycle present: " + detectCycle(edges));
    }

    public static boolean detectCycle(int[][] edges){

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inRecursion = new HashSet<>();

        for(int[] edge: edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }

        for(int i = 0; i < graph.size(); i++){
            if(!visited.contains(i) && dfs(graph, visited, inRecursion, i)){
                return true;
            }
        }
        return false;
    }

    public static boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> inRecursion, int u){

        visited.add(u);
        inRecursion.add(u);

        for(int v: graph.get(u)){

            if(!visited.contains(v) && dfs(graph, visited, inRecursion, v)){
                return true;
            }else if(inRecursion.contains(v)){
                return true;
            }
        }
        inRecursion.remove(u);
        return false;
    }
}
