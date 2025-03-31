package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        Integer[] arr = {4,9,0,5,1};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Total sum of all root-to-leaf nODES: " + sumNumbers(root));
    }

    static int sum=0;

    public static int sumNumbers(TreeNode root) {
        return findsum(root, sum);

    }

    public static int findsum(TreeNode root, int sum){
        if(root==null){
            return 0;
        }

        sum=sum*10 + root.val;

        int left= findsum(root.left, sum);
        int right= findsum(root.right, sum);

        if(left==0 && right==0){
            return sum+left+right;
        }else{
            return left+right;
        }
    }
}
