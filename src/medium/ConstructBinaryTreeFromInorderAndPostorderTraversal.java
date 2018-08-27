package medium;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int lowI, int hiI, int[] postorder, int lowP, int hiP) {

        if(lowI > hiI || lowP > hiP) return null;
        TreeNode root = new TreeNode(postorder[hiP]);

        int i = 0;
        while (i < inorder.length) {
            if(inorder[i] == postorder[hiP]) break;
            i++;
        }

        root.right = buildTree(inorder, i + 1, hiI, postorder, hiP - hiI + i, hiP - 1);
        root.left = buildTree(inorder, lowI, i - 1, postorder, lowP, hiP - hiI + i - 1);
        return root;
    }
}
