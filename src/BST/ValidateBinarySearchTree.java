package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Integer[] arr = {5,1,4,null,null,3,6};
        // output: false
        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTreeBST(arr);

        System.out.println("Is BST valid? : " + isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
