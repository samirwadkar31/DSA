package BinarySearch;

public class MinimumTimeToCompleteTrips {
    public static void main(String[] args) {
        int[] time= {1,2,3};
        int totalTrips= 5;
        System.out.println(minimumTime(time, totalTrips));
    }

    public static long minimumTime(int[] time, int totalTrips) {
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < time.length; i++) {
            minTime = Math.min(minTime, time[i]);
        }

        return binarySearchTotalTrips(time, (long) minTime * totalTrips, totalTrips);
    }

    public static long binarySearchTotalTrips(int[] time, long endTime, int totalTrips) {
        long start = 1;
        long end = endTime;

        while (start < end) {
            long mid = start + (end - start) / 2;

            if (canCompleteTotalTrips(time, mid, totalTrips)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static boolean canCompleteTotalTrips(int[] time, long mid, int totalTrips) {
        long possibleTrips = 0;

        for (int i = 0; i < time.length; i++) {
            possibleTrips += mid / time[i];
            if (possibleTrips >= totalTrips) return true;
        }
        return possibleTrips >= totalTrips;
    }
}
