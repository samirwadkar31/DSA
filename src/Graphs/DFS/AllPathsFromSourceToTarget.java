package Graphs.DFS;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};

        List<List<Integer>> ans = allPathsSourceTarget(graph);

        for(List<Integer> list: ans){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();

        int source=0;
        int target= graph.length-1;

        dfs(graph, result, templist, source, target);

        return result;
    }

    public static void dfs(int[][] graph, List<List<Integer>> result, List<Integer> templist, int u, int target){
        templist.add(u);

        if(u==target){
            result.add(new ArrayList<>(templist));
        }else{
            for(int v: graph[u]){
                dfs(graph, result, templist, v, target);
            }
        }

        templist.remove(templist.size()-1);
    }
}
