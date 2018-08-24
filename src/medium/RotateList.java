package medium;

public class RotateList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    //先在head处标记，再制作一个环形list，移位后断开即可
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode old = head;
        int len = 1;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        k = k % len;
        head.next = old;

        for(int i = len - k; i > 0; i--) {
            old = old.next;
        }
        head = old.next;
        old.next = null;
        return head;
    }
}
