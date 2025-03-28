package Trees;

public class AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {
        Integer[] arr = {1,5,3,null,4,10,6,9,2};

        BinaryTree tree = new BinaryTree();

        tree.buildTree(arr);

        tree.printTree(tree.root);
    }
}
