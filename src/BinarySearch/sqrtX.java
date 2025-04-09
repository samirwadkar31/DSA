package BinarySearch;

public class sqrtX {
    public static void main(String[] args) {
        int x = 64;
        // int x = 11; return floor value
        System.out.println("Square root of x is: " + mySqrt(x));
    }

    public static int mySqrt(int x) {
        int start=0;
        int end= x;


        while(start<=end){
            int mid= start+ (end-start)/2;

            if((long)mid*mid==(long)x){
                return mid;
            }else if((long)mid*mid<(long)x){
                start= mid+1;
            }else if((long)mid*mid>(long)x){
                end= mid-1;
            }
        }
        return end;
    }
}
