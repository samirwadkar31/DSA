package Graphs.UnionFind;

import java.util.HashMap;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        //{{0,1},{0,2},{1,2}};

        System.out.println(countPairs(n, edges));
    }

    public static long countPairs(int n, int[][] edges) {
        int[] parent= new int[n];
        int[] rank= new int[n];

        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        for(int[] edge: edges){
            union(edge[0], edge[1], parent, rank);
        }

        HashMap<Integer, Integer> map= new HashMap<>();

        for(int i=0; i<n; i++){

            int node= find(i, parent);

            map.put(node, map.getOrDefault(node,0)+1);
        }

        long ans=0;
        long remainingNodes=n;

        for(int val: map.values()){

            int size= val;
            ans+=size*(remainingNodes-size);
            remainingNodes-=size;
        }
        return ans;
    }

    public static void union(int a, int b, int[] parent, int[] rank){

        int p1= find(a, parent);
        int p2= find(b, parent);

        if(p1!=p2){

            if(rank[p1]>rank[p2]){
                parent[p2]=parent[p1];
            }else if(rank[p2]>rank[p1]){
                parent[p1]=parent[p2];
            }else{
                parent[p2]=parent[p1];
            }
        }
    }
    public static int find(int num, int[] parent){

        if(parent[num]==num){
            return num;
        }

        return parent[num]= find(parent[num], parent);
    }
}
