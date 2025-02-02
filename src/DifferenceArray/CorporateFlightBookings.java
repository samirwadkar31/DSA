package DifferenceArray;

import java.util.Arrays;

public class CorporateFlightBookings {
    public static void main(String[] args) {
        int n=5;
        int[][] bookings= {{1,2,10},{2,3,20},{2,5,25}};
        int[] ans= corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] corpFlightBookings(int[][] bookings, int n) {

        int diff[]= new int[n];

        for(int[] booking: bookings){

            diff[booking[0]-1]+=booking[2];
            if(booking[1]<n){
                diff[booking[1]]-=booking[2];
            }

        }

        for(int i=1; i<n; i++){
            diff[i]+=diff[i-1];
        }

        return diff;
    }
}
