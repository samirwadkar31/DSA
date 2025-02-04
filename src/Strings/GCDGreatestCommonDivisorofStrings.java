package Strings;

public class GCDGreatestCommonDivisorofStrings {
    public static void main(String[] args) {
        String str1= "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2= "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";

        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {

        if(!(str1+str2).equals(str2+str1)) return "";

        int gcd= findGCD(str1.length(), str2.length());

        return str1.substring(0, gcd);

    }

    public static int findGCD(int a, int b){
        // eg a=48, b=18
        while(b!=0){
            int temp= b;
            b=a%b;
            a=temp;
        }
        return a;

    }
}
