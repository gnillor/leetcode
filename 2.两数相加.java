/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;
            int value = v1 + v2 + carry;
            carry = 0;

            if (value >= 10) {
                value -= 10;
                carry = 1;
            }

            ListNode node = new ListNode(value);
            cursor.next = node;
            cursor = cursor.next;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            cursor.next = node;
            cursor = cursor.next;
        }

        return dummy.next;
    }
}
// @lc code=end
