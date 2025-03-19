package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);

        System.out.println(ans);
    }

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, n, sb, 0, 0);
        return res;
    }

    public static void helper(List<String> res, int n, StringBuilder sb, int open, int close){

        if(sb.length() == 2*n){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            helper(res, n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(")");
            helper(res, n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
