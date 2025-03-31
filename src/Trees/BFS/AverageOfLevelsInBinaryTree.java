package Trees.BFS;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        List<Double> ans = averageOfLevels(root);

        System.out.println("Average of levels in binary tree: " + ans);
    }

    public static List<Double> averageOfLevels(TreeNode root) {

        ArrayList<Double> levelAvg= new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            double levelsize= queue.size();
            double currentLevelAvg=0;
            double levelsum=0;
            for(double i=0; i<levelsize; i++){
                TreeNode currentNode= queue.poll();
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
                levelsum= levelsum+currentNode.val;
            }
            currentLevelAvg=levelsum/levelsize;
            levelAvg.add(currentLevelAvg);
        }
        return levelAvg;
    }
}
