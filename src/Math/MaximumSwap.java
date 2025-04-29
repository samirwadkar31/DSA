package Math;

public class MaximumSwap {

    public static void main(String[] args) {
        int num = 98368;

        System.out.println("Maximum number after at most one swap is: " + maximumSwap(num));
    }

    public static int maximumSwap(int num) {
        //99458
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        int[] last = new int[10];

        for(int i = 0; i < n; i++){
            last[digits[i] - '0'] = i;
        }

        for(int i = 0; i < n; i++){
            for(int d = 9; d > digits[i] - '0'; d--){

                if (last[d] > i) {

                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;

                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }
}
