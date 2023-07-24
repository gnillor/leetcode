/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = head.next;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
            curr = curr.next;
            next = next.next;
        }

        ListNode tail = curr;
        for (int i = 0; i < right - left; i++) {
            ListNode newNext = next.next;
            next.next = curr;
            curr = next;
            next = newNext;
        }

        prev.next = curr;
        tail.next = next;
        return dummy.next;
    }
}
// @lc code=end

