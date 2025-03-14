package Graphs;

public class FindTheTownJudge {
    public static void main(String[] args) {
        int[][] trust = {{1,3},{2,3},{3,1}};
        int n = 3;

//        Input: n = 3, trust = [[1,3],[2,3]]
//        Output: 3
        System.out.println("Judge of the town: " + findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {

        int[] degree= new int[n+1];

        for(int[] t: trust){

            degree[t[0]]--;

            degree[t[1]]++;

        }

        for(int i=1; i<=n; i++){

            if(degree[i]==n-1) return i;
        }

        return -1;
    }
}
