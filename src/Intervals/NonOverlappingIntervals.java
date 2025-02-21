package Intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals={{5,7},{8,9},{1,2},{3,4},{0,5},{5,9}};
                      // eg  [[5,7], [8,9], [1,2], [3,4], [0,5], [5,9]]
//after sorting end time     [[1,2], [3,4], [0,5], [5,7], [8,9], [5,9]]

        int ans= eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        int n= intervals.length;
        int m= intervals[0].length;
        Arrays.sort(intervals, (a, b)->(a[1]-b[1]));
        int count=0;
        int j=0;

        for(int i=1; i<n; i++){

            if(intervals[i][0]<intervals[j][1]){
                count++;
            }else{
                j=i;
            }
        }

        return count;
    }
}
