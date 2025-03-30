package Trees;
import java.util.List;
import java.util.ArrayList;

public class PathSum2 {
    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        int targetSum = 22;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        List<List<Integer>> ans = pathSum(root, targetSum);

        for(List<Integer> a: ans){
            System.out.print(a + " ");
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root==null) return new ArrayList<>();

        List<List<Integer>> result= new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        helper(result, root, targetSum, tempList);

        return result;
    }

    public static void helper(List<List<Integer>> result, TreeNode root, int targetSum, List<Integer> tempList){


        if(root==null) return;

        tempList.add(root.val);

        if (root.left == null && root.right == null && targetSum == root.val) {
            result.add(new ArrayList<>(tempList));
        } else {
            helper(result, root.left, targetSum - root.val, tempList);
            helper(result, root.right, targetSum - root.val, tempList);
        }

        tempList.remove(tempList.size() - 1);
    }
}
