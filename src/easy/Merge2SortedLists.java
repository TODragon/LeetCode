package easy;

public class Merge2SortedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
		ListNode solution = new ListNode(0);
//		ListNode kListNode = new ListNode(0);
//		kListNode.next = solution;
		ListNode kListNode = solution;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
//				ListNode temp = new ListNode(l1.val);
//				solution.next = temp;
//				solution = solution.next;
//				l1 = l1.next;
				solution.next = l1;
				l1 = l1.next;
				solution = solution.next;
			}
			else {
//				ListNode temp = new ListNode(l2.val);
//				solution.next = temp;
//				solution = solution.next;
//				l2 = l2.next;
				solution.next = l2;
				l2 = l2.next;
				solution = solution.next;
			}
		}
		if(l1 != null) solution.next = l1;
		if(l2 != null) solution.next = l2;
		return kListNode.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(4);
		l1.next = a;
		a.next = b;
		ListNode l2 = new ListNode(1);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(9);
 		l2.next = c;
		c.next = d;
		d.next = e;
		ListNode solution = mergeTwoList(l1, l2);
		while(solution != null) {
			System.out.println(solution.val);
			solution = solution.next;
			
		}
	}
}
