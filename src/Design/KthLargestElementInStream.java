package Design;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        KthLargest kthLargest = new KthLargest(k, nums);

        // Sample test cases
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> pq;


    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq= new PriorityQueue<>();

        for(int num: nums){
            add(num);
        }

    }

    public int add(int val) {

        pq.offer(val);

        if(pq.size()>k){
            pq.poll();
        }

        return pq.peek();
    }
}

