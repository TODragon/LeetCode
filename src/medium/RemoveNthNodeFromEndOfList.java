package medium;

public class RemoveNthNodeFromEndOfList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode current = head;
        ListNode past = head;
        for(int m = n; m > 0; m--) temp = temp.next;

        while(temp != null) {
            temp = temp.next;
            past = current;
            current = current.next;
        }
        if(current == head) return head.next;
        past.next = current.next;
        return head;
    }
}
