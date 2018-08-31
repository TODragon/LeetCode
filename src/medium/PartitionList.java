package medium;

public class PartitionList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    //多指针在小于和大于处标记并交换
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode res = new ListNode(x - 1);
        res.next = head;

        ListNode less = res;
        ListNode more = res;

        ListNode cur = res;
        while (cur.next != null) {
            if(cur.val < x && cur.next.val >= x) {
                less = cur;
                more = cur.next;
                break;
            }
            else cur = cur.next;
        }
        if(cur.next == null) return res.next;
        else cur = more.next;

        while (cur != null) {
            if(cur.val < x) {
                ListNode temp = cur;
                cur = cur.next;
                more.next = cur;
                temp.next = less.next;
                less.next = temp;
                less = less.next;
            }
            else {
                more = more.next;
                cur = cur.next;
            }
        }

        return res.next;
    }

    //jiuzhang solution
    //直接建两个一大一小的list连起来
    public ListNode partition1(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }

        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}
