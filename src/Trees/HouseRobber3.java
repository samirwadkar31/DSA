package Trees;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {
    public static void main(String[] args) {
        Integer[] arr = {3,2,3,null,3,null,1};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Max heist: " + rob(root));
    }

    public static Map<TreeNode, Integer> dp = new HashMap<>();

    public static int rob(TreeNode root) {
        if (root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);

        int robCurrent = root.val;
        if (root.left != null) {
            robCurrent += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            robCurrent += rob(root.right.left) + rob(root.right.right);
        }

        int skipCurrent = rob(root.left) + rob(root.right);
        int result = Math.max(robCurrent, skipCurrent);

        dp.put(root, result);
        return result;
    }
}
