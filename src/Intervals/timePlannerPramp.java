package Intervals;

public class timePlannerPramp {
    public static void main(String[] args) {
        int[][] slotsA = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slotsB = {{0, 15}, {60, 70}};
        int dur = 8;

        int[] ans = meetingPlanner(slotsA, slotsB, dur);

        for(int num: ans){
            System.out.print(num + " ");
        }
    }

    public static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int i = 0, j = 0;

        while (i < slotsA.length && j < slotsB.length) {
            int start = Math.max(slotsA[i][0], slotsB[j][0]);
            int end = Math.min(slotsA[i][1], slotsB[j][1]);

            if (end - start >= dur) {
                return new int[] {start, start + dur};
            }


            if (slotsA[i][1] < slotsB[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return new int[] {};
    }
}
