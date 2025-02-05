package Strings;

public class FindDiffInStrings {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDiff(s, t));
    }
    public static char findTheDiff(String s, String t) {

        int[] alpha= new int[26];

        int m= s.length();
        int n= t.length();

        for (int i = 0; i < m; i++) {
            alpha[s.charAt(i) - 'a']--;
        }

        for (int i = 0; i < n; i++) {
            alpha[t.charAt(i) - 'a']++;
        }

        for (int k = 0; k < 26; k++) {
            if (alpha[k] == 1) {
                return (char)(k + 'a');
            }
        }

        return 'a';
    }
}

