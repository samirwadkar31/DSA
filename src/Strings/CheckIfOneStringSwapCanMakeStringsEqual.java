package Strings;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        String s1 = "djrxsradfumetmknyvsyydhnibbtvphmhcjmeemgczdjttkbmayivbfowsnlhytqy";
        String s2 = "djrxsradfumetmknxvsyydhnibbtvphmhcjmeemgcydjttkbmayivbfowsnlhytqy";
        //output: false

        System.out.println("Is one swap possible to make strings equal: " + areAlmostEqual(s1, s2));
    }

    public static boolean areAlmostEqual(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int start = 0;
        int swap = 0;

        int i = -1;
        int j = -1;

        while(start < n){

            if(s1.charAt(start) == s2.charAt(start)){
                start++;
            }else{

                swap++;

                if(i == -1) i = start;
                else if(j == -1) j = start;

                start++;
            }

            if(swap > 2){
                return false;
            }
        }

        if(swap == 0) return true;
        if(swap == 1) return false;

        if(swap == 2 && (s1.charAt(i) != s2.charAt(j) || s1.charAt(j) != s2.charAt(i))){
            return false;
        }

        return true;
    }
}
