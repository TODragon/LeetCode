package easy;

public class MinimumDepthOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        return depth(root);
    }

    public static int depth(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return 1;

        return Math.min(depth(root.left), depth(root.right)) + 1;
    }

    //discuss
    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }

    public static void main(String args[]) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;

        System.out.println(minDepth(a));
    }
}
