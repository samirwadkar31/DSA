package Trees;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Integer[] arr = {1,2,2,3,3,null,null,4,4};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Total complete tree nodes: " + countNodes(root));
    }

    public static int countNodes(TreeNode root) {

        if(root==null) return 0;

        int leftHeight= getLeftHeight(root);
        int rightHeight= getRightHeight(root);

        if(leftHeight==rightHeight){
            return (int)(Math.pow(2, leftHeight)-1); // if perfect binary tree-> total nodes= 2^h-1
        }

        return countNodes(root.left) + countNodes(root.right)+1;
    }

    public static int getLeftHeight(TreeNode root){
        TreeNode temp= root;
        int height=0;

        while(temp!=null){
            temp=temp.left;
            height++;
        }

        return height;
    }

    public static int getRightHeight(TreeNode root){
        TreeNode temp= root;
        int height=0;

        while(temp!=null){
            temp=temp.right;
            height++;
        }

        return height;

    }
}
