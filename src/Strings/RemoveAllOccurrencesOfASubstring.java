package Strings;

public class RemoveAllOccurrencesOfASubstring {
    public static void main(String[] args) {
        String s= "daabcbaabcbc";
        String part= "abc";
        System.out.println("After removing part substrings from s: " + removeOccurrences(s, part));
    }

    public static String removeOccurrences(String s, String part) {

        int n= s.length();
        int m= part.length();

        StringBuilder sb= new StringBuilder();

        for(int i=0; i<n; i++){

            sb.append(s.charAt(i));

            if(sb.length()>=m && sb.substring(sb.length()-m).equals(part)){
                sb.delete(sb.length()-m, sb.length());
            }

        }
        return sb.toString();
    }
}
