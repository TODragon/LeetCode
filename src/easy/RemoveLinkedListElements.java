package easy;

public  class RemoveLinkedListElements {
    public class  ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;

        //处理头部节点
        while (head != null && head.val == val) head = head.next;
        if(head == null) return null;
        ListNode res = head;

        while (head.next != null) {
            if(head.next.val == val) head.next = head.next.next;
            else head = head.next;
        }

        return res;
    }
}
