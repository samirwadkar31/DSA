package Heaps;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int k=2;
        int[] nums= {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,k));


    }
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq= new PriorityQueue<>();

        for(int num: nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
