package easy;

public class IntersectionOf2LinkedLists {
    //O(n)time O(1)memory
    //简单的，可以将B与A一一比对，遍历B
    //O(n^2)time O(1)memory
    //如果从结尾到开头，可以达到，但是无法回溯

    //先将AB反转，可以，但要求AB依旧为原结构
    //O(n)time O(n)memory
    //如果用递归，怎么判断是否为子链呢
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //得到AB的长度，然后对齐，并检查
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = new ListNode(0);
        int lenA = 0;
        int lenB = 0;
        if(headA == headB) return headA;
        if(headA == null || headB == null) return null;

        temp = headA;
        while (temp != null) {
            temp = temp.next;
            lenA++;
        }

        temp = headB;
        while (temp != null) {
            temp = temp.next;
            lenB++;
        }

        if(lenA > lenB) {
            while (lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
        }

        else if(lenA < lenB) {
            while (lenA < lenB) {
                headB = headB.next;
                lenB--;
            }
        }

        if(lenA == lenB) {
            while (headA != null && headB != null) {
                if(headA == headB) return headA;
                else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
        }
        return null;
    }






    //jiuzhang solution
    //将AB连接然后检测是否有环路~
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // get the tail of list A.
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;
        ListNode result = listCycleII(headA);
        node.next = null;
        return result;
    }


    private ListNode listCycleII(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

//    Approach 3: Two Pointers
//    Maintain two pointers pApA and pBpB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
//    When pApA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pBpB reaches the end of a list, redirect it the head of A.
//            If at any point pApA meets pBpB, then pApA/pBpB is the intersection node.
//            To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'. Since B.length (=4) < A.length (=6), pBpB would reach the end of the merged list first, because pBpB traverses exactly 2 nodes less than pApA does. By redirecting pBpB to head A, and pApA to head B, we now ask pBpB to travel exactly 2 more nodes than pApA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
//    If two lists have intersection, then their last nodes must be the same one. So when pApA/pBpB reaches the end of a list, record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no intersections.
//    Complexity Analysis
//
//    Time complexity : O(m+n)O(m+n).
//
//    Space complexity : O(1)O(1).
    //boundary check
public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;

    ListNode a = headA;
    ListNode b = headB;

    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
        //for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;
    }

    return a;
}


    //discuss
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }




}
