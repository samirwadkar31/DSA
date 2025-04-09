package Graphs.UnionFind.Impelimentation;

import java.util.HashMap;
import java.util.Map;

public class DSUImplementation {

    public static void main(String[] args) {

        int[][] edges= {{0,1}, {1,2}, {2,3}, {3,1}, {5,6}};

        DSU obj= new DSU();

        for(int[] edge: edges){
            if(obj.union(edge[0], edge[1])){
                System.out.println(" They are already connected");
            }else{
                System.out.println(edge[0] + " is connected with "+ edge[1] );
            }
        }
    }
}

class DSU{

    Map<Integer,Integer> parent;
    Map<Integer, Integer> rank;

    public DSU(){
        parent= new HashMap<>();
        rank= new HashMap<>();

    }

    public void initializeTheParent(int node){

        if(!parent.containsKey(node)){
            parent.put(node, node);
            rank.put(node, 0);
        }
    }

    public boolean union(int node1, int node2){

        int node1Parent= find(node1);
        int node2Parent= find(node2);

        if(node1Parent!=node2Parent){

            if(rank.get(node1Parent)>rank.get(node2Parent)){
                parent.put(node2Parent, node1Parent);
            }else if(rank.get(node2Parent)>rank.get(node1Parent)){
                parent.put(node1Parent,node2Parent);
            }else{
                parent.put(node2Parent, node1Parent);
                rank.put(node1Parent, rank.getOrDefault(node1Parent,0)+1);
            }

            return false;
        }
        return true;
    }

    public int find(int node){
        initializeTheParent(node);
        if(parent.get(node)==node){
            return node;
        }

        parent.put(node, find(parent.get(node)));
        return parent.get(node);
    }
}
