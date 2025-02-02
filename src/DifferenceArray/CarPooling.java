package DifferenceArray;

public class CarPooling {
    public static void main(String[] args) {
        int capacity= 4;
        int[][] trips= {{2,1,5},{3,3,7}};
        System.out.println(carPooling(trips, capacity));
    }
    public static boolean carPooling(int[][] trips, int capacity) {
        int maxStop = 0;

        for (int[] trip : trips) {
            maxStop = Math.max(maxStop, trip[2]);
        }

        int[] diff = new int[maxStop + 1];

        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            if (trip[2] < maxStop) {
                diff[trip[2]] -= trip[0];
            }
        }

        if (diff[0] > capacity) {
            return false;
        }

        for (int i = 1; i < maxStop + 1; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}
