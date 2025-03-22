package Trie;

public class FindTheLengthOftheLongestCommonPrefix {
    public static void main(String[] args) {
        int[] arr1 = {1,10,100,25,2546};
        int[] arr2 = {1000, 2546798};

        System.out.println("Length of the longest common prefix is : " + longestCommonPrefix(arr1, arr2));
    }
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        Trie root = new Trie();

        int maxPrefix = 0;

        for(int num: arr2){
            insertNumbers(root, num);
        }

        for(int num: arr1){
            maxPrefix = Math.max(maxPrefix, search(root, num));
        }

        return maxPrefix;
    }

    public static int search(Trie root, int num){

        Trie node = root;
        String s = Integer.toString(num);
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(node.children[ch - '0'] != null){
                count++;
                node = node.children[ch - '0'];
            }else{
                break;
            }
        }

        return count;
    }

    public static void insertNumbers(Trie root, int num){
        Trie node = root;
        String s = Integer.toString(num);
        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);
            if(node.children[ch -'0'] == null){
                node.children[ch -'0'] = new Trie();
            }
            node = node.children[ch -'0'];
        }
    }
}
