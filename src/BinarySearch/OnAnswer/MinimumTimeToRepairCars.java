package BinarySearch.OnAnswer;

public class MinimumTimeToRepairCars {
    public static void main(String[] args) {
        int[] ranks = {4,3,2,1};
        int cars = 10;

        System.out.println("Minimum time to repair all given cars is " + repairCars(ranks, cars) + " minutes.");
    }

    public static long repairCars(int[] ranks, int cars) {

        int n = ranks.length;
        int maxRank = 0;

        for(int i = 0; i < n; i++){

            maxRank = Math.max(maxRank, ranks[i]);
        }

        long start = 1;
        long end = (long)maxRank * cars * cars;

        long ans = 0;

        while(start <= end){

            long mid = start + (end - start)/2;

            if(repairPossible(ranks, mid, cars)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public static boolean repairPossible(int[] ranks, long time, int cars){

        long carCount = 0;

        for(int i = 0; i < ranks.length; i++){
            carCount += (long) Math.sqrt((double) time / ranks[i]);
            if(carCount >= cars) return true;
        }

        return carCount >= cars;
    }
}
