package Intervals;

import java.util.Arrays;

public class MeetingsRoom {
    public static void main(String[] args) {
        int[][] intervals={{1,6},{2,4},{15,18}};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {

        int n = intervals.length;

        if(n == 0 || n == 1){
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        for(int i= 1; i<n; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}
