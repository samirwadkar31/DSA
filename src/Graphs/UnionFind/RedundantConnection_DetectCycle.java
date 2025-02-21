package Graphs.UnionFind;

public class RedundantConnection_DetectCycle {

    public static void main(String[] args) {
        int[][] edges= {{1,2},{1,3},{2,3}};
        //[[1,2],[2,3],[3,4],[1,4],[1,5]]
        int[] RedundantConnection= findRedundantConnection(edges);

        for(int num: RedundantConnection){
            System.out.println(num);
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        int[] lastRedundantEdge= new int[2];
        int[] parent= new int[n+1];
        int[] rank= new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i]=i;
        }

        for(int[] edge: edges){
            int a= edge[0];
            int b= edge[1];

            if(unionFind(a,b, parent, rank)){ //cycle is present
                lastRedundantEdge = edge;
            }
        }

        return lastRedundantEdge;
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
