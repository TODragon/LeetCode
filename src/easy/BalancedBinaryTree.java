package easy;

public class BalancedBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    //jiuzhang solution
    public boolean isBalanced(TreeNode root) {
    return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) return 0;

        if(maxDepth(root.left) == -1 || maxDepth(root.right) == -1 || Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return -1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
