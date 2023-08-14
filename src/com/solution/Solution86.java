package com.solution;

/**
 * @Description
 * @Date 2022/7/4 19:19
 * @Created by ZHOUXINJIAN3
 */
public class Solution86 {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1);
            ListNode dummy2 = new ListNode(-1);
            ListNode p1 = dummy1, p2 = dummy2;
            ListNode p = head;
            while (p != null) {
                if (p.val >= x) {
                    p2.next = p;
                    p2 = p2.next;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                }
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }
            p1.next = dummy2.next;
            return dummy1.next;
        }
    }
}
