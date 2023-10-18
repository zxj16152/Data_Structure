package com.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 243->342, 564->465
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Solution111111 {
    public static List<Integer> addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> res = new ArrayList<>();
        int carry = 0;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + carry;
            if (value > 9) {
                value = (value % 10);
                carry = 1;
            } else {
                carry = 0;
            }
            res.add(value);
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int value = l1.val + carry;
            if (value > 9) {
                value = (value % 10);
                carry = 1;
            } else {
                carry = 0;
            }
            res.add(value);
            l1 = l1.next;
        }
        while (l2 != null) {
            int value = l2.val + carry;
            if (value > 9) {
                value = (value % 10);
                carry = 1;
            } else {
                carry = 0;
            }
            res.add(value);
            l2 = l2.next;
        }
        if (carry != 0) {
            res.add(carry);
        }

//        Collections.reverse(res);
        return res;
    }

    private static ListNode reverseNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode res = reverseNode(head.next);
        ListNode temp = head;
        head.next.next = temp;
        head.next = null;
        return res;

    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;


        ListNode h1 = new ListNode(9);
        ListNode h2 = new ListNode(9);
        ListNode h3 = new ListNode(9);
        ListNode h4 = new ListNode(9);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        ListNode head1 = reverseNode(n1);
        ListNode head2 = reverseNode(h1);
        List<Integer> integers = addTwoNumbers(head1, head2);
        System.out.println(integers);
    }
}
