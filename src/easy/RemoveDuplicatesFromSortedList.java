package easy;

public class RemoveDuplicatesFromSortedList {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {this.val = x;}
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode solution = head;
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        while (temp != null) {
            while (temp != null && temp.val == head.val){
                head.next = temp.next;
                temp = temp.next;
            }

            if(temp != null) {
                head = head.next;
                temp = temp.next;
            }
        }
        return solution;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String args[]) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode s = deleteDuplicates(a);
        System.out.println(s.val);
        System.out.println(s.next.val);
        System.out.println(s.next.next.val);
        System.out.println(deleteDuplicates(e).val);
    }
}
