package easy;

public class SameTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }
    //有点小错 = =
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null && p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(q.right, q.right);
        else if(p == null && q == null) return true;
        else {return false;}
    }
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        else if (p==null || q==null) return false;
        else return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if((p == null & q != null) || (p != null && q == null)) return false;
        else if(p == null && q == null) return true;
        else if(p.val != q.val) return false;
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
