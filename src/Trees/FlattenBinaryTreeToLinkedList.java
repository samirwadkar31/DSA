package Trees;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        Integer[] arr = {1,2,5,3,4,null,6};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);
        flatten(root);
        tree.printTree(root);
    }

    public static void flatten(TreeNode root) {

        TreeNode currentNode= root;
        while(currentNode!=null){
            TreeNode temp= currentNode.left;
            if(currentNode.left!=null){
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=currentNode.right;
                currentNode.right=currentNode.left;
                currentNode.left=null;
            }
            currentNode=currentNode.right;
        }
    }
}
