package medium;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    //recursive
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int lowP, int hiP, int lowI, int hiI) {

        if(lowI > hiI) return null;
        TreeNode root = new TreeNode(preorder[lowP]);
        if(lowI == hiI) return root;
        int i = 0;
        while (i < inorder.length) {
            if(inorder[i] == preorder[lowP]) break;
            i++;
        }
        root.left = buildTree(preorder, inorder, lowP + 1, lowP + i - lowI, lowI, i - 1);
//        root.right = buildTree(preorder, inorder, lowP + i - lowI + 1, hiP, i + 1, hiI);
        root.right = buildTree(preorder, inorder, hiP + i - hiI + 1, hiP, i + 1, hiI);
        return root;
    }

    public static void main(System args[]) {
        int[] preordeer = {1,2};
        int[] inorder = {2,1};
        buildTree(preordeer, inorder);
        System.out.print(654);
    }


    private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
                                 int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, preorder[prestart]);

        root.left = myBuildTree(inorder, instart, position - 1,
                preorder, prestart + 1, prestart + position - instart);
        root.right = myBuildTree(inorder, position + 1, inend,
                preorder, position - inend + preend + 1, preend);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }


}
