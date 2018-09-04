package medium;

public class ConvertSortedListToBinarySearchTree {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    //二分查找，分别记录长度 递归
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = 0;
        ListNode res = head;
        while (head != null) {
            head = head.next;
            len++;
        }
        return binaryLB(res, 0, len - 1);
    }

    private static TreeNode binaryLB(ListNode head, int lo, int hi){
//        if(lo == hi) return new TreeNode(head.val);
        if(lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        int i = mid;
        ListNode temp = head;
        while (i != 0) {
            temp = temp.next;
            i--;
        }
        if(lo == hi) return new TreeNode(temp.val);
        TreeNode res = new TreeNode(temp.val);
        res.left = binaryLB(head, lo, mid - 1);
        res.right = binaryLB(head, mid + 1, hi);

        return res;
    }

    //-10,-3,0,5,9==2. 01 34..

    public static void main(String args[]) {
        ListNode a = new ListNode(-10);
        ListNode b = new ListNode(-3);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        sortedListToBST(a);
        System.out.print(" 616");
    }


    //discuss
    public ListNode curList;
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;

        //return dfs(head);
        int index = 0;
        ListNode cur = head;
        curList = head;
        while (cur != null) {
            cur = cur.next;
            index++;
        }

        return dfs(0, index);
    }
    private TreeNode dfs(int start, int end) {
        if (start > end || curList == null) return null;

        int mid = start + (end - start) / 2;

        TreeNode left = dfs(start, mid - 1);
        TreeNode curRoot = new TreeNode(curList.val);
        curRoot.left = left;

        curList = curList.next;
        curRoot.right = dfs(mid + 1, end);

        return curRoot;
    }
    private TreeNode dfs1(ListNode head) {
        if (head == null) return null;

        ListNode prev = getMidPrev(head);
        ListNode mid = prev.next == null ? head : prev.next;

        TreeNode root = new TreeNode(mid.val);
        if (mid != head) {
            prev.next = null;
            root.left = dfs1(head);
        }

        root.right = dfs1(mid.next);

        return root;
    }
    private ListNode getMidPrev(ListNode head) {
        ListNode slow = null, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow == null ? head : slow.next;
            fast = fast.next.next;
        }
        return slow == null ? head : slow;
    }

    //
    public TreeNode sortedListToBST2(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
}
