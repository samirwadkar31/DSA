package Intervals;

import java.util.Arrays;

public class CountDaysWithoutMeetings {
    public static void main(String[] args) {
        int days = 15;
        int[][] meetings = {{5,7},{2,3},{9,10}};
        System.out.println("Days Without meetings: " + countDays(days, meetings));
    }

    public static int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, (x, y)->x[0]-y[0]);
        int a = meetings[0][0];
        int b = meetings[0][1];
        int res = a - 1;

        for(int i = 1; i< meetings.length; i++){

            if(Math.min(meetings[i][1], b) - Math.max(meetings[i][0], a) < 0){
                res += meetings[i][0] - b -1;
                a = meetings[i][0];
                b = meetings[i][1];
            }else{
                b = Math.max(meetings[i][1],b);
            }
        }

        if(b != days){
            res += days - b;
        }


        return res;
    }
}
