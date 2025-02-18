package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
    public static void main(String[] args) {
        String digits= "23";
        List<String> ans= letterCombinations(digits);

        for(String str: ans) {
            System.out.println(str);
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        String[] mappings = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();
        helper(result, digits, mappings, new StringBuilder(), 0);
        return result;
    }

    private static void helper(List<String> result, String digits, String[] mappings, StringBuilder current, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mappings[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            helper(result, digits, mappings, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
