package medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {val = x;}
    }

    //bfs
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if(root == null) return;
        queue.offer(root);
        int cur = 1;
        int next = 0;
        while (queue.size() != 0) {
            while (cur != 0) {
                TreeLinkNode temp = queue.poll();
                cur--;
                if(cur != 0) temp.next = queue.peek();

                if(temp.left != null) {
                    next++;
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    next++;
                    queue.offer(temp.right);
                }
            }
            cur = next;
            next = 0;
        }
    }


    public void connect1(TreeLinkNode root) {
        TreeLinkNode parent = root;
        while (parent != null) {
            TreeLinkNode headOfNextLevel = null;
            TreeLinkNode prev = null;
            while(parent != null) {
                if (headOfNextLevel == null) {
                    headOfNextLevel = (parent.left != null) ? parent.left : parent.right;
                }

                if (parent.left != null) {
                    if (prev != null) {
                        prev.next = parent.left;
                        prev = prev.next;
                    } else {
                        prev = parent.left;
                    }
                }

                if (parent.right != null) {
                    if (prev != null) {
                        prev.next = parent.right;
                        prev = prev.next;
                    } else {
                        prev = parent.right;
                    }
                }
                parent = parent.next;
            }
            parent = headOfNextLevel;
        }
    }
}
