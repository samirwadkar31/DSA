package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.Stack;

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        Integer[] arr = {5,3,6,2,4,null,null,1};
        int k = 3;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTreeBST(arr);

        System.out.println("Kth smallest element in BST: " + kthSmallest(root, k));
    }

    public static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root= root.left;
            }

            root=stack.pop();

            k--;
            if(k==0){
                break;
            }
            root=root.right;
        }
        return root.val;
    }
}
