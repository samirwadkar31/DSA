package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {

    public static void main(String[] args) {

        int k = 2;
        int w = 4;
        int[] profits = {10, 20, 30, 40, 50};
        int[] capital = {0, 5, 10, 15, 20};
        System.out.println("Maximum capital earned after taking K distinct projects: " + findMaximizedCapital(k, w, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;

        List<int[]> projects = new ArrayList<>();

        for(int i = 0; i < n; i++){
            projects.add(new int[]{capital[i], profits[i]});
        }

        Collections.sort(projects, (a, b)->a[0]-b[0]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);

        int j=0;

        for(int i = 0; i < k; i++){

            while(j < n && projects.get(j)[0] <= w){
                maxHeap.offer(projects.get(j)[1]);
                j++;
            }

            if(maxHeap.isEmpty()) break;

            w += maxHeap.poll();
        }

        return w;
    }
}
