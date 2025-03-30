package Trees;

public class PathSum {
    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int targetSum = 22;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Is target sum present is any of the paths?: " + hasPathSum(root, targetSum));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if(root==null){
            return false;
        }

        if(targetSum==root.val && root.left==null && root.right==null){
            return true;
        }

        boolean left= hasPathSum(root.left, targetSum-root.val);
        boolean right= hasPathSum(root.right, targetSum-root.val);

        return left || right;

    }
}
