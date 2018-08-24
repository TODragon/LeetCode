package easy;

public class PathSum {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
    //recursive
//    public boolean hasPathSum(TreeNode root, int sum) {
//
//
//
//    }








    //jiuzhang solution
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum1 (root.left, sum - root.val)
                || hasPathSum1(root.right, sum - root.val);
    }
}
