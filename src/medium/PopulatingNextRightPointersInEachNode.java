package medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {val = x;}
    }
    //bfs queue
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if(root == null) return;
        queue.offer(root);
        int i = 1;
        while(queue.size() != 0) {
            int n = i;
            while (n != 0) {
                TreeLinkNode temp = queue.poll();
                n--;
                if(n == 0) temp.next = null;
                else temp.next = queue.peek();
                if(temp.left != null && temp.right != null) {
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
            i *= 2;
        }
    }


    //jiuzhang solution
    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode parent = root;
        TreeLinkNode next = parent.left;
        while (parent != null && next != null) {
            TreeLinkNode prev = null;
            while (parent != null) {
                if (prev == null) {
                    prev = parent.left;
                } else {
                    prev.next = parent.left;
                    prev = prev.next;
                }
                prev.next = parent.right;
                prev = prev.next;
                parent = parent.next;
            }
            parent = next;
            next = parent.left;
        }
    }

    //discuss
    public void connect2(TreeLinkNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        if(root.left != null && root.right != null)
            root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;

        connect2(root.left);
        connect2(root.right);
    }
}
