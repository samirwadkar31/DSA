package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 4;

        List<List<Integer>> res = kSmallestPairs(nums1, nums2, k);

        for(List<Integer> pair: res){
            System.out.print(pair + " ");
        }
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq= new PriorityQueue<>((a, b) -> b[0]-a[0]);

        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){

                int sum= nums1[i] + nums2[j];

                pq.offer(new int[]{sum, i, j});

                if(pq.size() > k){
                    pq.poll();
                }
            }
        }

        while(!pq.isEmpty()){
            int[] top= pq.poll();
            List<Integer> tempList= new ArrayList<>();
            tempList.add(nums1[top[1]]);
            tempList.add(nums2[top[2]]);
            ans.add(tempList);
        }
        return ans;
    }
}
