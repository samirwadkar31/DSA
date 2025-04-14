package SlidingWindow.OnStrings;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    public static void main(String[] args) {

        String s = "abciiidef";
        int k = 3;
        System.out.println("Maximum Number of Vowels in a Substring of Given Length: " + maxVowels(s, k));

    }

    public static int maxVowels(String s, int k) {

        int n= s.length();
        int count=0;
        int maxCount=0;

        int left=0;

        for(int right=0; right<n; right++){

            if(isVowel(s.charAt(right))){
                count++;
            }

            if(right-left+1>k){

                if(isVowel(s.charAt(left))){
                    count--;
                }
                left++;
            }

            if(right-left+1==k){
                maxCount= Math.max(count, maxCount);
            }
        }
        return maxCount;
    }

    public static boolean isVowel(char ch){

        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
