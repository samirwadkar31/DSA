package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

public class DeleteNodeInBST {
    public static void main(String[] args) {
        Integer[] arr = {5,3,6,2,4,null,7};
        int key = 3;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTreeBST(arr);
        tree.printTreeBST(root);

        System.out.println();

        TreeNode ans = deleteNode(root, key);
        tree.printTreeBST(ans); //prints level wise
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        TreeNode dummy=root;

        if(root.val==key){
            return helper(root, dummy);
        }


        while(root!=null){

            if(root.left!=null && root.left.val==key){
                root.left= helper(root.left, dummy);
                return dummy;
            }else if(root.right!=null && root.right.val==key){
                root.right= helper(root.right, dummy);
                return dummy;
            }else if(key<root.val){
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return dummy;

    }

    public static TreeNode helper(TreeNode node, TreeNode dummy){

        if(node.left!=null && node.right!=null && node.val<=dummy.val){
            TreeNode temp= node.right;

            while(temp.left!=null){
                temp=temp.left;
            }

            temp.left=node.left;
            return node.right;
        }else if(node.left!=null && node.right!=null && node.val>dummy.val){
            TreeNode temp= node.left;

            while(temp.right!=null){
                temp=temp.right;
            }

            temp.right=node.right;
            return node.left;
        }else if(node.left==null){
            return node.right;
        }else{
            return node.left;
        }
    }
}
