package BinarySearch.OnAnswer;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights= {1,2,3,4,5,6,7,8,9,10};
        int days= 5;

        System.out.println("Least weight capacity of the ship= " + shipWithinDays(weights, days));

    }

    public static int shipWithinDays(int[] weights, int days) {
        int n= weights.length;
        int sum=0;
        int start_max_weight=0;

        for(int i=0; i<n; i++){
            sum+=weights[i];
            start_max_weight= Math.max(start_max_weight,weights[i]);
        }

        int start= start_max_weight;
        int end= sum;

        while(start<end){
            int mid= start+(end-start)/2;

            if(canShip(weights, mid, days)){
                end= mid;
            }else{
                start= mid+1;
            }
        }
        return start;
    }

    private static boolean canShip(int[] weights, int mid, int days){
        int sum=0;
        int count=1;

        for(int i=0; i<weights.length; i++){
            sum+=weights[i];
            if(sum>mid){
                count++;
                sum=weights[i];
            }
        }
        return count<=days;
    }
}
