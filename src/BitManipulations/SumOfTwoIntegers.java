package BitManipulations;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }

    public static int getSum(int a, int b) {

        while(b!=0){ // keep doing sum until there is no carry
            int carry= (a&b)<<1; // carry
            a=a^b; // sum without carry
            b=carry;
        }

        return a;
    }
}
