package Heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,8,8,8,8,8,5,6,7,7,7,7};
        int k = 2;
        //output {7,8}

        int[] res = topKFrequent(nums, k);
        for(int num: res){
            System.out.print(num + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {

        int n= nums.length;

        HashMap<Integer, Integer> map= new HashMap<>();
        PriorityQueue<int[]> pq= new PriorityQueue<>((a, b)->a[1]-b[1]);

        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(int key: map.keySet()){
            pq.offer(new int[]{key, map.get(key)});

            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] ans= new int[k];

        for(int i=0; i<k; i++){
            ans[i]= pq.poll()[0];
        }

        return ans;
    }
}
