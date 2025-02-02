package Graphs.UnionFind;

import java.util.Arrays;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    int components;
    int[] parent;
    int[] rank;
    
    public static void main(String[] args) {
        int[][] logs = {{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}};
        int n = 6;
        TheEarliestMomentWhenEveryoneBecomeFriends solution = new TheEarliestMomentWhenEveryoneBecomeFriends();
        int result = solution.earliestAcq(logs, n);
        System.out.println("The earliest moment when everyone becomes friends: " + result);
    }
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        parent= new int[n];
        rank= new int[n];
        components=n;

        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        for(int i=0; i<logs.length; i++){
            int timestamp=logs[i][0];
            int a= logs[i][1];
            int b= logs[i][2];
            if(union(a,b)){
                return timestamp;
            }
        }
        return -1;
    }

    public boolean union(int a, int b){
        int p1= find(a);
        int p2= find(b);

        if(p1!=p2){
            if(rank[p1]>rank[p2]){
                parent[p2]=p1;
            }else if(rank[p2]>rank[p1]){
                parent[p1]=p2;
            }else{
                parent[p2]=p1;
                rank[p1]++;
            }
            components--;
            if(components==1){
                return true;
            }
        }
        return false;
    }

    public int find(int num){
        if(parent[num]==num){
            return num;
        }
        return parent[num]= find(parent[num]);
    }
}
