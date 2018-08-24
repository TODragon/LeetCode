package medium;

import org.w3c.dom.NodeList;

public class Add2Numbers {
	private static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int x) {val = x;}
	}
	
	//求和后表示为list，会有int溢出问题。。。。。。。。无法解决
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode solution = p;
        int num = int2List(l1) + int2List(l2);
        String str = num + "";
        for(int pow = 1; pow <= str.length(); pow++) {
        	ListNode a = new ListNode(num % 10);
        	num /= 10;
        	p.next = a;
        	p = p.next;
        }
        return solution.next;
    }
    public static int int2List(ListNode l) {
    	int num = 0;
    	int pow = 0;
    	while(l != null) {
    		num += l.val * Math.pow(10, pow);
    		l = l.next;
    		pow++;
    	}
		return num;
	} 
    
    //分别计算，带进位plus
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0;
        int pow = 0;
        int plus = 0;
        ListNode a = new ListNode(0);
        ListNode solution = a;
        
        while(l1 != null && l2 != null) {
        	int temp = l1.val + l2.val + plus;
        	if(temp >= 10) plus = 1;
        	else plus = 0;
        	ListNode node = new ListNode(temp % 10);
        	a.next = node;
        	a = a.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while(l1 != null) {
        	int temp = l1.val + plus;
        	if(temp >= 10) plus = 1;
        	else plus = 0;
        	ListNode node = new ListNode(temp % 10);
        	a.next = node;
        	a = a.next;
        	l1 = l1.next;
        }
        while(l2 != null) {
        	int temp = l2.val + plus;
        	if(temp >= 10) plus = 1;
        	else plus = 0;
        	ListNode node = new ListNode(temp % 10);
        	a.next = node;
        	a = a.next;
        	l2 = l2.next;
        }
        if(plus == 1) {
        	ListNode ex = new ListNode(1);
        	a.next = ex;
        }
        
        return solution.next;
    }
    
    //jiuzhang solution
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;
        for (ListNode i = l1, j = l2; i != null || j != null; ) {
            int sum = carry;
            sum += (i != null) ? i.val : 0;
            sum += (j != null) ? j.val : 0;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            carry = sum / 10;
            i = (i == null) ? i : i.next;
            j = (j == null) ? j : j.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }
    public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(4);
		a.next = b;
		b.next = c;
		
		d.next = e;
		e.next = f;
		System.out.println(int2List(a));
		System.out.println(int2List(d) + int2List(a));
		System.out.println(addTwoNumbers(a, d).val);
		System.out.println(addTwoNumbers(a, d).next.val);
		System.out.println(addTwoNumbers(a, d).next.next.val);
//		System.out.println(addTwoNumbers(a, d).next.next.next.val);
		
		
	}
}
