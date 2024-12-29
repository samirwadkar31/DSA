package Heaps;

import java.util.PriorityQueue;
public class MinHeap {
    public static void main(String[] args) {
        int[] nums= {5,7,8,3,2,-4,99};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.offer(num);
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
