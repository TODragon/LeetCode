package medium;

public class InsertionSortList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0);
        while (head != null) {
            ListNode i = res;
            while (i.next != null && i.next.val < head.val) i = i.next;
            ListNode temp = head.next;
            head.next = i.next;
            i.next = head;
            head = temp;
        }

        return res.next;
    }
}
