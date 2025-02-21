package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals={{1,6},{2,4},{15,18}};
        // normal [[1,3],[2,6],[8,10],[15,18]]
        // tricky [[1,6], [2,4], [15,18]]  use math.max here

        int[][] ans= merge(intervals);

        for(int[] interval: ans){
            System.out.println(interval[0] + ", " + interval[1]);
        }
    }
    public static int[][] merge(int[][] intervals) {
        int n= intervals.length;

        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        List<int[]> ans= new ArrayList<>();

        for(int[] interval: intervals){
            if(ans.isEmpty()){
                ans.add(interval);
            }else if(ans.get(ans.size()-1)[1]>=interval[0]){
                ans.get(ans.size()-1)[1]= Math.max(ans.get(ans.size()-1)[1],interval[1]);
            }else{
                ans.add(interval);
            }
        }

        int[][] result= ans.toArray(new int[ans.size()][]);
        return result;
    }

}
