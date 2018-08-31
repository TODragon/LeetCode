package medium;

public class RemoveDuplicatesFromSortedListII {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    //第一个可能重复，先加一个节点
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode res = new ListNode(-head.val);
        res.next = head;
        ListNode cur = res;

        while (cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
            else cur = cur.next;
        }

        return res.next;
    }
}
