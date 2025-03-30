package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        List<List<Integer>> ans = levelOrder(root);

        for(List<Integer> a: ans){
            System.out.print(a + " ");
        }

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.size()!=0){
            int levelsize= queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for(int i=0; i<levelsize;i++){
                TreeNode currentNode= queue.poll();
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
                levelList.add(currentNode.val);
            }
            result.add(levelList);

        }
        return result;
    }
}
