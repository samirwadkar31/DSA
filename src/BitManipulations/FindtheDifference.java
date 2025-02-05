package BitManipulations;

public class FindtheDifference {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s,t));
    }

    public static char findTheDifference(String s, String t) {
        char diff=0;

        for (char c : s.toCharArray()) {
            diff ^= c;
        }

        for (char c : t.toCharArray()) {
            diff ^= c;
        }

        return diff;     // cool trick using XOR
    }
}
