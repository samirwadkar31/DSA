package BinarySearch.OnAnswer;

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9}; // other example 10, 1, 2, 7, 5
        int k = 3;

        System.out.println(" Maximum minimum distance between any two cows is " + maxMinDistance(stalls, k));
    }

    public static int maxMinDistance(int[] stalls, int k){

        int n = stalls.length;
        Arrays.sort(stalls);

        int max = 0;
        int min = 0;

        for(int i =0; i < n; i++){
            min = Math.min(min, stalls[i]);
            max = Math.max(max, stalls[i]);
        }

        int start = 1;
        int end = max - min;
        int ans = 0;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(cowCanBePlaced(stalls, k, mid)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }

    public static boolean cowCanBePlaced(int[] stalls, int k, int dist){

        int cows = 1;
        int lastCow = 0;

        for(int i = 1; i < stalls.length; i++){

            if(stalls[i] - stalls[lastCow] >= dist){
                cows++;
                lastCow = i;
            }

            if(cows == k){
                return true;
            }

        }

        return cows < k ? false: true;

    }
}
