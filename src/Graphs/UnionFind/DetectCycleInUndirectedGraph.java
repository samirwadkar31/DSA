package Graphs.UnionFind;

import java.util.*;

public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {
        int[][] edges= {{1,2},{1,3},{2,3}};
        //{{1,2},{2,3},{3,4},{1,4},{1,5}}

        System.out.println("Is cycle present: " + detectCycle(edges));
    }
    public static boolean detectCycle(int[][] edges){
        int n= edges.length;
        int[] parent= new int[n+1];
        int[] rank= new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i]=i;
        }

        for(int[] edge: edges){
            if(unionFind(edge[0], edge[1], parent, rank)){
                return true;
            }
        }
        return false;
    }
    public static boolean unionFind(int a, int b, int[] parent, int[] rank){
        int p1= find(a, parent);
        int p2= find(b, parent);

        if(p1!=p2){

            if(rank[p1]>rank[p2]){
                parent[p2]=parent[p1];
            }else if(rank[p2]>rank[p1]){
                parent[p1]=parent[p2];
            }else{
                parent[p2]=parent[p1];
                rank[p1]++;
            }
            return false;
        }
        return true;
    }

    public static int find(int num, int[] parent){
        if(parent[num]==num){
            return num;
        }
        return parent[num]= find(parent[num], parent);
    }
}
