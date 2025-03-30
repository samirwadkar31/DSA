package BinarySearch.OnAnswer;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position= {1,2,3,4,7};
        int m = 3;
        System.out.println("Maximum minimum magnetic force between any two balls is " + maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int max = 0;
        int min = 0;

        for(int i =0; i < n; i++){
            min = Math.min(min, position[i]);
            max = Math.max(max, position[i]);
        }

        int start = 1;
        int end = max - min;
        int ans = 0;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(ballsCanBePlaced(position, m, mid)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }

    public static boolean ballsCanBePlaced(int[] position, int m, int force){

        int balls = 1;
        int lastBall = 0;

        for(int i = 1; i < position.length; i++){

            if(position[i] - position[lastBall] >= force){
                balls++;
                lastBall = i;
            }

            if(balls == m){
                return true;
            }

        }

        return balls < m ? false: true;

    }
}
