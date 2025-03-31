package Trees.BFS;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {1,7,0,7,-8,null,null};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        int ans = maxLevelSum(root);

        System.out.println("Level which has maximum sum: " + ans);
    }

    public static int maxLevelSum(TreeNode root) {

        int level=1;
        int currentLevel=1;
        int maximumSum= Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelsize=queue.size();
            int levelSum=0;
            for(int i=0; i<levelsize; i++){
                TreeNode currentNode= queue.poll();
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
                levelSum=levelSum+currentNode.val;
            }
            if(maximumSum<levelSum){
                maximumSum=levelSum;
                level= currentLevel;
            }
            currentLevel++;
        }

        return level;
    }
}
