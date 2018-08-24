package easy;

import java.util.ArrayList;

public class LinkedListCycle {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ArrayList<ListNode> solution = new ArrayList<>();
        if(head == null) return false;
        while (head != null) {
            if(solution.contains(head)) return true;
            else {
                solution.add(head);
                head = head.next;
            }
        }
        return false;
    }


    //jiuzhang solution
    //使用两个指针，一个快一个慢，快的一次2步，慢的一次1步，有环会相遇 O(1)space
    public Boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
