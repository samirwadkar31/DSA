package Strings;

public class AddStrings {
    public static void main(String[] args) {
        String num1= "456"; //or 99
        String num2= "77";  //or 999
        System.out.println("After adding strings: " + addStrings(num1, num2) );
    }

    public static String addStrings(String num1, String num2) {

        int n= num1.length()-1;
        int m= num2.length()-1;

        StringBuilder sb= new StringBuilder();
        int carry=0;

        while(n>=0 || m>=0){

            int sum=carry;

            if(n>=0){
                sum+=num1.charAt(n)-'0';
            }

            if(m>=0){
                sum+=num2.charAt(m)-'0';
            }

            carry=sum/10;
            sum=sum%10;
            sb.append(sum);
            n--;
            m--;
        }

        if(carry!=0) sb.append(carry);

        return sb.reverse().toString();
    }
}
