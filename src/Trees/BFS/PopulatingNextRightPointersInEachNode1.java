package Trees.BFS;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode1 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        TreeNode ans = connect(root);

        tree.printTree(ans);
    }

    public static TreeNode connect(TreeNode root) {
        if(root==null) return root;

        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n= queue.size();
            TreeNode prev=null;

            for(int i=0; i<n; i++){
                TreeNode curr= queue.poll();

                if(prev!=null){
                    prev.next=curr;
                }
                prev=curr;
                if(curr.left!=null){
                    queue.offer(curr.left);
                }

                if(curr.right!=null){
                    queue.offer(curr.right);
                }

                if(i==n-1) curr.next=null;
            }
        }
        return root;
    }
}
