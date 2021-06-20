package code.arvin.leetcode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class P002AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursion(l1, l2, false);
    }

    public ListNode recursion(ListNode l1, ListNode l2, boolean gt10) {
        if (l1 == null && l2 == null) {
            if (gt10) {
                return new ListNode(1);
            } else {
                return null;
            }
        }
        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (gt10 ? 1 : 0);
        return new ListNode(val >= 10 ? val - 10 : val, recursion(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val >= 10));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
