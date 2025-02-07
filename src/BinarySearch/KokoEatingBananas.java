package BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int h= 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int maxBananas=0;

        for(int i=0; i<piles.length; i++){
            maxBananas= Math.max(maxBananas, piles[i]);
        }

        return binarySearch(piles, maxBananas, h);
    }

    public static int binarySearch(int[] piles, int maxBananas, int h){
        int start=1;
        int end= maxBananas;

        while(start<end){
            int mid= start+ (end-start)/2;

            if(canEat(piles, mid, h)){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }

    public static boolean canEat(int[] piles, int mid, int h){
        int totalHours=0;

        for(int i=0; i<piles.length; i++){
            totalHours+=piles[i]/mid;
            if(piles[i]%mid!=0) totalHours++;
        }
        return totalHours<=h;
    }
}
