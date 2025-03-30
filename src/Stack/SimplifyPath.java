package Stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
        //output: "/.../b/d"
        // path = "/a/../..hello/b/c/"

        System.out.println("Simplified Path: " + simplifyPath(path));
    }

    public static String simplifyPath(String path) {

        int n = path.length();

        Stack<String> stack = new Stack<>();

        String[] files = path.split("/");

        for(String file: files){

            if(file.equals(".") || file.equals("")) continue;

            if(stack.isEmpty() && file.equals("..")) continue;

            if(!stack.isEmpty() && file.equals("..")){
                stack.pop();
                continue;
            }

            stack.push(file);
        }

        if(stack.isEmpty()) return new String("/");

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.insert(0, stack.pop()).insert(0, '/');
        }

        return sb.toString();
    }
}
