package Trees.TreeViews;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,null,null,null,5};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        List<Integer> ans = rightSideView(root);

        for(int a: ans){
            System.out.print(a + " ");
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();


        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int n= queue.size();
            for(int i=0; i<n; i++){
                TreeNode currentNode= queue.poll();

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
                if(i == n-1){
                    ans.add(currentNode.val);
                }
            }
        }

        return ans;
    }
}
