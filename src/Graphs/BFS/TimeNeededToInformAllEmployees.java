package Graphs.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        int n = 11;
        int headID = 4;
        int[] manager = {5,9,6,10,-1,8,9,1,9,3,4};
        int[] informTime = {0,213,0,253,686,170,975,0,261,309,337};

        System.out.println("Time needed to inform all employees: " + numOfMinutes(n, headID, manager, informTime));
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            if(manager[i] == -1) continue;

            adj.get(manager[i]).add(i);
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{informTime[headID], headID});

        int totalTime = 0;

        while(!queue.isEmpty()){

            int[] temp = queue.poll();

            int time = temp[0];
            int u = temp[1];

            for(int v: adj.get(u)){

                queue.offer(new int[]{time + informTime[v], v});
            }

            totalTime = Math.max(totalTime, time);
        }

        return totalTime;
    }
}
