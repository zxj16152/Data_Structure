package com.solution;

import java.util.LinkedList;

public class Solution027 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        LinkedList<Integer> stack = new LinkedList<>();
        while (fast.next != null) {
            if (fast.next.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow.next != null) {
            stack.addFirst(slow.next.val);
            slow = slow.next;
        }

        ListNode pre = head;
        while (!stack.isEmpty()) {
            Integer value = stack.pollFirst();
            if (pre.val != value) {
                return false;
            }
            pre = pre.next;
        }
        return true;
    }
    

    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode reverse = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution027 solution = new Solution027();
//        solution.isPalindrome(n1);
        ListNode reverse = solution.reverse(n1);
        System.out.println(reverse);
    }
}
