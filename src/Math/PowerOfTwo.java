package Math;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n=16;
        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {

        if(n<=0) return false;

        // while(n%2==0){      TC O(log(n))
        //     n=n/2;
        // }

        // return n==1;

        return (n & (n-1)) == 0;  // cool trick TC O(1)

    }
}
