package TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s= "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int start=0;
        int end= s.length()-1;

        if(s.isEmpty()){
            return true;
        }

        while(start<=end){

            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }else{
                if(Character.toLowerCase(s.charAt(start))==Character.toLowerCase(s.charAt(end))){
                    start++;
                    end--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
