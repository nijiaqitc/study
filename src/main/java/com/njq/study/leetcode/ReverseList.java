package com.njq.study.leetcode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        ListNode head1 = reverseList(head);
        ListNode temp = head1;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
